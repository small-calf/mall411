package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 店铺等级
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("store_rank")
public class StoreRankEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId()
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
	 * 排序
	 */
	private Integer orders;
	/**
	 * 是否允许注册
	 */
	private Boolean isAllowRegister;
	/**
	 * memo
	 */
	private String memo;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 可发布商品数
	 */
	private Long quantity;
	/**
	 * 服务费
	 */
	private BigDecimal serviceFee;

}
