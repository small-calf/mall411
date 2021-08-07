package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.mall.dao.ReceiverDao;
import com.wyl.mall.entity.ReceiverEntity;
import com.wyl.mall.service.ReceiverService;


@Service("receiverService")
public class ReceiverServiceImpl extends ServiceImpl<ReceiverDao, ReceiverEntity> implements ReceiverService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReceiverEntity> page = this.page(
                new Query<ReceiverEntity>().getPage(params),
                new QueryWrapper<ReceiverEntity>()
        );

        return new PageUtils(page);
    }

}