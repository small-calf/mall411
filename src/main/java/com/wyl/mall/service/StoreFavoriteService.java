package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.entity.StoreFavoriteEntity;
import com.wyl.mall.utils.PageUtils;

import java.util.Map;

/**
 * 店铺收藏
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface StoreFavoriteService extends IService<StoreFavoriteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

