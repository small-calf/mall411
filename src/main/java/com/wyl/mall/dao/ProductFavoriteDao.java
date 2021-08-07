package com.wyl.mall.dao;

import com.wyl.mall.entity.ProductFavoriteEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品收藏
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-07 15:28:06
 */
@Mapper
public interface ProductFavoriteDao extends BaseMapper<ProductFavoriteEntity> {
	
}
