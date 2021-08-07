package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.StockLogEntity;
import com.wyl.mall.utils.PageUtils;

import java.util.Map;

/**
 * 库存记录
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface StockLogService extends IService<StockLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

