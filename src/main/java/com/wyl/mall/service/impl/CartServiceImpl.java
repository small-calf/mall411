package com.wyl.mall.service.impl;

import com.wyl.mall.dao.CartItemDao;
import com.wyl.mall.entity.CartItemEntity;
import com.wyl.mall.utils.JWTUtil;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.CartDao;
import com.wyl.mall.entity.CartEntity;
import com.wyl.mall.service.CartService;

import javax.annotation.Resource;


@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private CartDao cartDao;

    @Resource
    private CartItemDao cartItemDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CartEntity> page = this.page(
                new Query<CartEntity>().getPage(params),
                new QueryWrapper<CartEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R cart(String token) {
        String userId = JWTUtil.getUsername(token);
        String redisToken = String.valueOf(redisTemplate.opsForValue().get(userId));

        if (!token.equals(redisToken)) {
            return R.error(403,"权限错误");
        }
        CartEntity cartEntity = cartDao.selectOne(new QueryWrapper<CartEntity>().eq("member_id", userId));
        if (cartEntity == null) {
            return R.error(401,"当前购物车不存在");
        }
        List<CartItemEntity> cartItemEntities = cartItemDao.selectList(new QueryWrapper<CartItemEntity>().eq("cart_id", cartEntity.getId()));
        return R.ok().put("data",cartItemEntities);
    }


}