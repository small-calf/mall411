package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.dto.OrdersDto;
import com.wyl.mall.entity.OrdersEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 订单
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface OrdersService extends IService<OrdersEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R createOrders(OrdersDto ordersDto, HttpServletRequest request);

    R listOrders(HttpServletRequest request);
}

