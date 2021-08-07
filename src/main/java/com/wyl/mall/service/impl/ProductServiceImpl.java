package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.ProductDao;
import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.service.ProductService;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductEntity> page = this.page(
                new Query<ProductEntity>().getPage(params),
                new QueryWrapper<ProductEntity>()
        );

        return new PageUtils(page);
    }

}