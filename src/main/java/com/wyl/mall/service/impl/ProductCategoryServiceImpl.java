package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.ProductCategoryDao;
import com.wyl.mall.entity.ProductCategoryEntity;
import com.wyl.mall.service.ProductCategoryService;


@Service("productCategoryService")
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategoryEntity> implements ProductCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductCategoryEntity> page = this.page(
                new Query<ProductCategoryEntity>().getPage(params),
                new QueryWrapper<ProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

}