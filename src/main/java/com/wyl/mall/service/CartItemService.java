package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.CartItemEntity;
import com.wyl.mall.utils.PageUtils;

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
}

