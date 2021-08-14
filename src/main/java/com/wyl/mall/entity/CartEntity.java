package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 购物车
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("cart")
@ApiModel("购物车")
public class CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 创建日期
	 */
	private Date createdDate;
	/**
	 * 最后修改日期
	 */
	private Date lastModifiedDate;
	/**
	 * 版本
	 */
	private Long version;
	/**
	 * 过期时间
	 */
	private Date expire;
	/**
	 * 密钥
	 */
	private String cartKey;
	/**
	 * 会员
	 */
	private Long memberId;

}
