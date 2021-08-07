package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.ProductFavoriteEntity;
import com.wyl.mall.utils.PageUtils;

import java.util.Map;

/**
 * 商品收藏
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-07 15:28:06
 */
public interface ProductFavoriteService extends IService<ProductFavoriteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
