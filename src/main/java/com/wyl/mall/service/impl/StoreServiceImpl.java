package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.StoreDao;
import com.wyl.mall.entity.StoreEntity;
import com.wyl.mall.service.StoreService;


@Service("storeService")
public class StoreServiceImpl extends ServiceImpl<StoreDao, StoreEntity> implements StoreService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StoreEntity> page = this.page(
                new Query<StoreEntity>().getPage(params),
                new QueryWrapper<StoreEntity>()
        );

        return new PageUtils(page);
    }

}