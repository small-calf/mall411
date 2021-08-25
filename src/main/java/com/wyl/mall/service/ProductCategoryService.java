package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.ProductCategoryEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;

import java.util.Map;

/**
 * 商品分类
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface ProductCategoryService extends IService<ProductCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R threeProductCategory();

    R oneProductCategory();

    Long searchIdByName(String categoryName);
}

