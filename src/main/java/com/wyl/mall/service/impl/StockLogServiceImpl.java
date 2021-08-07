package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.StockLogDao;
import com.wyl.mall.entity.StockLogEntity;
import com.wyl.mall.service.StockLogService;


@Service("stockLogService")
public class StockLogServiceImpl extends ServiceImpl<StockLogDao, StockLogEntity> implements StockLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockLogEntity> page = this.page(
                new Query<StockLogEntity>().getPage(params),
                new QueryWrapper<StockLogEntity>()
        );

        return new PageUtils(page);
    }

}