package com.wyl.mall.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Data
public class ReceiverDto {

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
	private Long version = 0L;
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
	private int isDefault;
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

}
