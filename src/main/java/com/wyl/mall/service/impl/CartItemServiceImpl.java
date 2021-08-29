package com.wyl.mall.service.impl;

import com.wyl.mall.dao.CartDao;
import com.wyl.mall.dao.ProductDao;
import com.wyl.mall.entity.CartEntity;
import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.mall.dao.CartItemDao;
import com.wyl.mall.entity.CartItemEntity;
import com.wyl.mall.service.CartItemService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Service("cartItemService")
public class CartItemServiceImpl extends ServiceImpl<CartItemDao, CartItemEntity> implements CartItemService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private ProductDao productDao;

    @Autowired
    private TokenUtils tokenUtils;

    @Resource
    private CartItemDao cartItemDao;

    @Resource
    private CartDao cartDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CartItemEntity> page = this.page(
                new Query<CartItemEntity>().getPage(params),
                new QueryWrapper<CartItemEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查看购物车中的某一项
     * @param productId
     * @param request
     * @return
     */
    @Override
    public R cartItem(Long productId, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = JWTUtil.getUsername(token);
        String redisToken = redisTemplate.opsForValue().get(userId).toString();
        if (!token.equals(redisToken)) {
            return R.error(403,"权限错误");
        }
        ProductEntity productEntity = productDao.selectById(productId);
        return R.ok().put("data",productEntity);
    }

    @Transactional
    @Override
    public Map<String, Object> selectListProduct(Long productId, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return map;
        }

        CartEntity cartEntity = cartDao.selectOne(new QueryWrapper<CartEntity>().eq("member_id", userId));

        if (cartEntity == null) {
            cartEntity = new CartEntity();
            cartEntity.setMemberId(Long.parseLong(userId));
            cartEntity.setCreatedDate(new Date());
            cartEntity.setLastModifiedDate(new Date());
            cartEntity.setVersion(0L);
            cartDao.insert(cartEntity);
        }

        CartItemEntity cartItemEntity = cartItemDao.selectOne(new QueryWrapper<CartItemEntity>().eq("sku_id", productId).eq("cart_id",cartEntity.getId()));


        map.put("cartItemEntity",cartItemEntity);
        map.put("userId",userId);

        return map;
    }

    @Transactional
    @Override
    public R addCartItem(Long productId, Long userId) {

        CartEntity cartEntity = cartDao.selectOne(new QueryWrapper<CartEntity>().eq("member_id", userId));

        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setCreatedDate(new Date());
        cartItemEntity.setLastModifiedDate(new Date());
        cartItemEntity.setVersion(0L);
        cartItemEntity.setQuantity(1);
        cartItemEntity.setCartId(cartEntity.getId());
        cartItemEntity.setSkuId(productId);

        cartItemDao.insert(cartItemEntity);
        return R.ok();
    }

    @Override
    public R updateCartItem(Long productId, Long userId) {

        CartEntity cartEntity = cartDao.selectOne(new QueryWrapper<CartEntity>().eq("member_id", userId));

        CartItemEntity itemEntity = cartItemDao.selectOne(new QueryWrapper<CartItemEntity>().eq("sku_id", productId).eq("cart_id", cartEntity.getId()));

        itemEntity.setLastModifiedDate(new Date());
        itemEntity.setQuantity(itemEntity.getQuantity() + 1);

        cartItemDao.updateById(itemEntity);

        return R.ok();
    }

    @Override
    public R buttonCartItem(Long productId, int addorreduce, HttpServletRequest request) {
        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }
        CartEntity cartEntity = cartDao.selectOne(new QueryWrapper<CartEntity>().eq("member_id", userId));

        CartItemEntity cartItemEntity = cartItemDao.selectOne(new QueryWrapper<CartItemEntity>().eq("sku_id", productId).eq("cart_id", cartEntity.getId()));

        if (addorreduce == 0) {//加
            cartItemEntity.setLastModifiedDate(new Date());
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() + 1);
            cartItemDao.updateById(cartItemEntity);

        }else {//减
            cartItemEntity.setLastModifiedDate(new Date());
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() - 1);
            cartItemDao.updateById(cartItemEntity);
        }
        return R.ok();
    }

    @Override
    public R selectDelete(String[] productId, HttpServletRequest request) {

        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }
        CartEntity cartEntity = cartDao.selectOne(new QueryWrapper<CartEntity>().eq("member_id", userId));

        for (String s:productId
             ) {

            cartItemDao.delete(new QueryWrapper<CartItemEntity>().eq("sku_id", s).eq("cart_id", cartEntity.getId()));

        }

        return R.ok();
    }


}