package com.wyl.mall.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("orders")
public class OrdersDto {

	/**
	 * ID
	 */
	private Long id;
	/**
	 * 创建日期
	 */
	private Date createdDate = new Date();
	/**
	 * 最后修改日期
	 */
	private Date lastModifiedDate = new Date();
	/**
	 * 版本
	 */
	private Long version;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 订单金额
	 */
	private BigDecimal amount;
	/**
	 * 已付金额
	 */
	private BigDecimal amountPaid;
	/**
	 * 地区名称
	 */
	private String areaName;
	/**
	 * 完成日期
	 */
	private Date completeDate;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 兑换积分
	 */
	private Long exchangePoint;
	/**
	 * 过期时间
	 */
	private Date expire;
	/**
	 * 支付手续费
	 */
	private BigDecimal fee;
	/**
	 * 运费
	 */
	private BigDecimal freight;
	/**
	 * 发票内容
	 */
	private String invoiceContent;
	/**
	 * 发票税号
	 */
	private String invoiceTaxNumber;
	/**
	 * 发票抬头
	 */
	private String invoiceTitle;
	/**
	 * 是否已分配库存
	 */
	private Boolean isAllocatedStock;
	/**
	 * 是否已兑换积分
	 */
	private Boolean isExchangePoint;
	/**
	 * 是否已评论
	 */
	private Boolean isReviewed;
	/**
	 * 附言
	 */
	private String memo;
	/**
	 * 调整金额
	 */
	private BigDecimal offsetAmount;
	/**
	 * 支付方式名称
	 */
	private String paymentMethodName;
	/**
	 * 支付方式类型
	 */
	private Integer paymentMethodType;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 数量
	 */
	private Integer quantity;
	/**
	 * 退款金额
	 */
	private BigDecimal refundAmount;
	/**
	 * 已退货数量
	 */
	private Integer returnedQuantity;
	/**
	 * 赠送积分
	 */
	private Long rewardPoint;
	/**
	 * 已发货数量
	 */
	private Integer shippedQuantity;
	/**
	 * 配送方式名称
	 */
	private String shippingMethodName;
	/**
	 * 编号
	 */
	private String sn;
	/**
	 * 状态 0：待发货1：待收货2：待付款3：已完成
	 */
	private Integer status;
	/**
	 * 税金
	 */
	private BigDecimal tax;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 重量
	 */
	private Integer weight;
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
	/**
	 * 支付方式
	 */
	private Long paymentMethodId;
	/**
	 * 配送方式
	 */
	private Long shippingMethodId;
	/**
	 * 店铺
	 */
	private Long storeId;
	/**
	 * 是否已导出
	 */
	private Boolean isExport;
	/**
	 * 导出时间
	 */
	private Date exportDate;
	/**
	 * 
	 */
	private Integer isRefund;
	/**
	 * 同步状态
	 */
	private String erpSync;
	/**
	 * 同步时间
	 */
	private Date erpSyncTime;
	/**
	 * ERP同步报文
	 */
	private String erpMsg;
	/**
	 * 数据来源
	 */
	private Integer dataSource;

}
