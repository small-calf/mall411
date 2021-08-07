package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 店铺
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("store")
public class StoreEntity implements Serializable {
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
	 * 已付保证金
	 */
	private BigDecimal bailPaid;
	/**
	 * E-mail
	 */
	private String email;
	/**
	 * 到期日期
	 */
	private Date endDate;
	/**
	 * 简介
	 */
	private String introduction;
	/**
	 * 是否启用
	 */
	private Boolean isEnabled;
	/**
	 * 搜索关键词
	 */
	private String keyword;
	/**
	 * logo
	 */
	private String logo;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 商家
	 */
	private Long businessId;
	/**
	 * 店铺分类
	 */
	private Long storeCategoryId;
	/**
	 * 店铺等级
	 */
	private Long storeRankId;
	/**
	 * 店铺管理人员
	 */
	private String storeUsers;
	/**
	 * 门店编码
	 */
	private String storeNo;
	/**
	 * 地区ID，逗号隔开
	 */
	private String areaTids;
	/**
	 * 运费起步价
	 */
	private String maxPrice;
	/**
	 * 额外运费
	 */
	private BigDecimal extraFreight;

}
