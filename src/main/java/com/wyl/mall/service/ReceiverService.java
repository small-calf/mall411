package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.ReceiverEntity;
import com.wyl.mall.utils.PageUtils;

import java.util.Map;

/**
 * 收货地址
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface ReceiverService extends IService<ReceiverEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

