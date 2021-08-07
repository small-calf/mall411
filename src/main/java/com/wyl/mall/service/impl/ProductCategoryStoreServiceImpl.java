package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.ProductCategoryStoreDao;
import com.wyl.mall.entity.ProductCategoryStoreEntity;
import com.wyl.mall.service.ProductCategoryStoreService;


@Service("productCategoryStoreService")
public class ProductCategoryStoreServiceImpl extends ServiceImpl<ProductCategoryStoreDao, ProductCategoryStoreEntity> implements ProductCategoryStoreService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductCategoryStoreEntity> page = this.page(
                new Query<ProductCategoryStoreEntity>().getPage(params),
                new QueryWrapper<ProductCategoryStoreEntity>()
        );

        return new PageUtils(page);
    }

}