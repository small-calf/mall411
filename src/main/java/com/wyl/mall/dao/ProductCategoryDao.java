package com.wyl.mall.dao;

import com.wyl.mall.entity.ProductCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Mapper
public interface ProductCategoryDao extends BaseMapper<ProductCategoryEntity> {
	
}
