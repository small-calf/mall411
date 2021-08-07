package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收货地址
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("receiver")
public class ReceiverEntity implements Serializable {
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
	 * 地址
	 */
	private String address;
	/**
	 * 地区名称
	 */
	private String areaName;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 是否默认
	 */
	private Boolean isDefault;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 地区
	 */
	private Long areaId;
	/**
	 * 会员
	 */
	private Long memberId;

}
