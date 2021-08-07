package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.StoreFavoriteDao;
import com.wyl.mall.entity.StoreFavoriteEntity;
import com.wyl.mall.service.StoreFavoriteService;


@Service("storeFavoriteService")
public class StoreFavoriteServiceImpl extends ServiceImpl<StoreFavoriteDao, StoreFavoriteEntity> implements StoreFavoriteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StoreFavoriteEntity> page = this.page(
                new Query<StoreFavoriteEntity>().getPage(params),
                new QueryWrapper<StoreFavoriteEntity>()
        );

        return new PageUtils(page);
    }

}