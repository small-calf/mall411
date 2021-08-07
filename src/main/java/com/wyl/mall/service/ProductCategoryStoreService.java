package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.ProductCategoryStoreEntity;
import com.wyl.mall.utils.PageUtils;

import java.util.Map;

/**
 * 商品分类店铺绑定
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface ProductCategoryStoreService extends IService<ProductCategoryStoreEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

