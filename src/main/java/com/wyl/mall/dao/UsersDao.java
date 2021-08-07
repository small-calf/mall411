package com.wyl.mall.dao;

import com.wyl.mall.entity.UsersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Mapper
public interface UsersDao extends BaseMapper<UsersEntity> {
	
}
