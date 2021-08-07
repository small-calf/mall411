package com.wyl.mall.service.impl;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.CartDao;
import com.wyl.mall.entity.CartEntity;
import com.wyl.mall.service.CartService;


@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CartEntity> page = this.page(
                new Query<CartEntity>().getPage(params),
                new QueryWrapper<CartEntity>()
        );

        return new PageUtils(page);
    }

}