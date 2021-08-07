package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.wyl.mall.dao.ProductFavoriteDao;
import com.wyl.mall.entity.ProductFavoriteEntity;
import com.wyl.mall.service.ProductFavoriteService;


@Service("productFavoriteService")
public class ProductFavoriteServiceImpl extends ServiceImpl<ProductFavoriteDao, ProductFavoriteEntity> implements ProductFavoriteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductFavoriteEntity> page = this.page(
                new Query<ProductFavoriteEntity>().getPage(params),
                new QueryWrapper<ProductFavoriteEntity>()
        );

        return new PageUtils(page);
    }

}