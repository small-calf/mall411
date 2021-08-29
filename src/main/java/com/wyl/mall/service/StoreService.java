package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.StoreEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;

import java.util.Map;

/**
 * 店铺
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface StoreService extends IService<StoreEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R selectByStoreId(String storeId);

    R storeInfo(String storeId);
}

