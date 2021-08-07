package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.StoreRankDao;
import com.wyl.mall.entity.StoreRankEntity;
import com.wyl.mall.service.StoreRankService;


@Service("storeRankService")
public class StoreRankServiceImpl extends ServiceImpl<StoreRankDao, StoreRankEntity> implements StoreRankService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StoreRankEntity> page = this.page(
                new Query<StoreRankEntity>().getPage(params),
                new QueryWrapper<StoreRankEntity>()
        );

        return new PageUtils(page);
    }

}