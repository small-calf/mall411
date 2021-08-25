package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;

import java.util.Map;

/**
 * 商品
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface ProductService extends IService<ProductEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R searchaProduct(String searchCondition);

    R categorySearchProduct(Long id);

    R categorySearchProductBySort(Long id,int sort);

    R searchaProductBySort(String sortName, int sort);

    R getProductInfo(Long id);
}

