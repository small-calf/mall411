package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.CartEntity;
import com.wyl.mall.utils.PageUtils;

import java.util.Map;

/**
 * 购物车
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface CartService extends IService<CartEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

