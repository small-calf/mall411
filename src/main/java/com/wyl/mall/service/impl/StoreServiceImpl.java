package com.wyl.mall.service.impl;

import com.wyl.mall.dao.ProductDao;
import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.StoreDao;
import com.wyl.mall.entity.StoreEntity;
import com.wyl.mall.service.StoreService;

import javax.annotation.Resource;


@Service("storeService")
public class StoreServiceImpl extends ServiceImpl<StoreDao, StoreEntity> implements StoreService {

    @Resource
    private ProductDao productDao;

    @Resource
    private StoreDao storeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StoreEntity> page = this.page(
                new Query<StoreEntity>().getPage(params),
                new QueryWrapper<StoreEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R selectByStoreId(String storeId) {
        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("store_id",storeId);
        List<ProductEntity> productEntities = productDao.selectList(wrapper);
        return R.ok().put("data",productEntities);
    }

    @Override
    public R storeInfo(String storeId) {
        StoreEntity storeEntity = storeDao.selectById(storeId);
        return R.ok().put("data",storeEntity);
    }

}