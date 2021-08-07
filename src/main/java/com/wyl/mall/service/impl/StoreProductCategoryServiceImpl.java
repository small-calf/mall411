package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.mall.dao.StoreProductCategoryDao;
import com.wyl.mall.entity.StoreProductCategoryEntity;
import com.wyl.mall.service.StoreProductCategoryService;


@Service("storeProductCategoryService")
public class StoreProductCategoryServiceImpl extends ServiceImpl<StoreProductCategoryDao, StoreProductCategoryEntity> implements StoreProductCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StoreProductCategoryEntity> page = this.page(
                new Query<StoreProductCategoryEntity>().getPage(params),
                new QueryWrapper<StoreProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

}