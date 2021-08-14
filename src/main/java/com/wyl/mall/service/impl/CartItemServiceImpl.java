package com.wyl.mall.service.impl;

import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.mall.dao.CartItemDao;
import com.wyl.mall.entity.CartItemEntity;
import com.wyl.mall.service.CartItemService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Service("cartItemService")
public class CartItemServiceImpl extends ServiceImpl<CartItemDao, CartItemEntity> implements CartItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CartItemEntity> page = this.page(
                new Query<CartItemEntity>().getPage(params),
                new QueryWrapper<CartItemEntity>()
        );

        return new PageUtils(page);
    }


}