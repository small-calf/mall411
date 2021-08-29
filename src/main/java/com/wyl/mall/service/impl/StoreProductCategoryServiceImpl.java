package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.mall.dao.StoreProductCategoryDao;
import com.wyl.mall.entity.StoreProductCategoryEntity;
import com.wyl.mall.service.StoreProductCategoryService;

import javax.annotation.Resource;


@Service("storeProductCategoryService")
public class StoreProductCategoryServiceImpl extends ServiceImpl<StoreProductCategoryDao, StoreProductCategoryEntity> implements StoreProductCategoryService {

    @Resource
    private StoreProductCategoryDao storeProductCategoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StoreProductCategoryEntity> page = this.page(
                new Query<StoreProductCategoryEntity>().getPage(params),
                new QueryWrapper<StoreProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R allCategoryByStore(String storeId) {
        QueryWrapper<StoreProductCategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("store_id",storeId);
        List<StoreProductCategoryEntity> storeProductCategoryEntities = storeProductCategoryDao.selectList(queryWrapper);
        return R.ok().put("data",storeProductCategoryEntities);
    }

}