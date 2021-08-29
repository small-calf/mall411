package com.wyl.mall.service.impl;

import com.wyl.mall.dto.OrdersDto;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import com.wyl.mall.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.OrdersDao;
import com.wyl.mall.entity.OrdersEntity;
import com.wyl.mall.service.OrdersService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Autowired
    private TokenUtils tokenUtils;

    @Resource
    private OrdersDao ordersDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrdersEntity> page = this.page(
                new Query<OrdersEntity>().getPage(params),
                new QueryWrapper<OrdersEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R createOrders(OrdersDto ordersDto, HttpServletRequest request) {
        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }

        OrdersEntity ordersEntity = new OrdersEntity();
        BeanUtils.copyProperties(ordersDto, ordersEntity);
        ordersDao.insert(ordersEntity);
        return R.ok();
    }

    @Override
    public R listOrders(HttpServletRequest request) {

        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }
        List<OrdersEntity> ordersEntities = ordersDao.selectList(new QueryWrapper<OrdersEntity>().eq("member_id", userId));
        return R.ok().put("data",ordersEntities);
    }

}