package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 库存记录
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("stock_log")
public class StockLogEntity implements Serializable {
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
	 * 入库数量
	 */
	private Integer inQuantity;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 出库数量
	 */
	private Integer outQuantity;
	/**
	 * 当前库存
	 */
	private Integer stock;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * SKU
	 */
	private Long skuId;

}
