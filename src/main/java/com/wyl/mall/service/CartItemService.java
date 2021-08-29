package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.CartItemEntity;
import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 购物车项
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface CartItemService extends IService<CartItemEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R cartItem(Long productId, HttpServletRequest request);

    Map<String,Object> selectListProduct(Long productId, HttpServletRequest request);

    R addCartItem(Long productId, Long userId);

    R updateCartItem(Long productId, Long userId);

    R buttonCartItem(Long productId ,int addorreduce, HttpServletRequest request);

    R selectDelete(String[] productId, HttpServletRequest request);
}

