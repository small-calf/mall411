package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.StoreRankEntity;
import com.wyl.mall.utils.PageUtils;

import java.util.Map;

/**
 * 店铺等级
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface StoreRankService extends IService<StoreRankEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

