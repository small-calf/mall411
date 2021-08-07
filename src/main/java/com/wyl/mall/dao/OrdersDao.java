package com.wyl.mall.dao;

import com.wyl.mall.entity.OrdersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Mapper
public interface OrdersDao extends BaseMapper<OrdersEntity> {
	
}
