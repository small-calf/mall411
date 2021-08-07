package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("product")
public class ProductEntity implements Serializable {
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
	 * 属性值0
	 */
	private String attributeValue0;
	/**
	 * 属性值1
	 */
	private String attributeValue1;
	/**
	 * 属性值10
	 */
	private String attributeValue10;
	/**
	 * 属性值11
	 */
	private String attributeValue11;
	/**
	 * 属性值12
	 */
	private String attributeValue12;
	/**
	 * 属性值13
	 */
	private String attributeValue13;
	/**
	 * 属性值14
	 */
	private String attributeValue14;
	/**
	 * 属性值15
	 */
	private String attributeValue15;
	/**
	 * 属性值16
	 */
	private String attributeValue16;
	/**
	 * 属性值17
	 */
	private String attributeValue17;
	/**
	 * 属性值18
	 */
	private String attributeValue18;
	/**
	 * 属性值19
	 */
	private String attributeValue19;
	/**
	 * 属性值2
	 */
	private String attributeValue2;
	/**
	 * 属性值3
	 */
	private String attributeValue3;
	/**
	 * 属性值4
	 */
	private String attributeValue4;
	/**
	 * 属性值5
	 */
	private String attributeValue5;
	/**
	 * 属性值6
	 */
	private String attributeValue6;
	/**
	 * 属性值7
	 */
	private String attributeValue7;
	/**
	 * 属性值8
	 */
	private String attributeValue8;
	/**
	 * 属性值9
	 */
	private String attributeValue9;
	/**
	 * 副标题
	 */
	private String caption;
	/**
	 * 成本价
	 */
	private BigDecimal cost;
	/**
	 * 点击数
	 */
	private Long hits;
	/**
	 * 介绍
	 */
	private String introduction;
	/**
	 * 是否有效
	 */
	private Boolean isActive;
	/**
	 * 是否需要物流
	 */
	private Boolean isDelivery;
	/**
	 * 是否列出
	 */
	private Boolean isList;
	/**
	 * 是否上架
	 */
	private Boolean isMarketable;
	/**
	 * 是否置顶
	 */
	private Boolean isTop;
	/**
	 * 搜索关键词
	 */
	private String keyword;
	/**
	 * 市场价
	 */
	private BigDecimal marketPrice;
	/**
	 * 最大佣金
	 */
	private BigDecimal maxCommission;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 月点击数
	 */
	private Long monthHits;
	/**
	 * 月点击数更新日期
	 */
	private Date monthHitsDate;
	/**
	 * 月销量
	 */
	private Long monthSales;
	/**
	 * 月销量更新日期
	 */
	private Date monthSalesDate;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 参数值
	 */
	private String parameterValues;
	/**
	 * 销售价
	 */
	private BigDecimal price;
	/**
	 * 商品图片
	 */
	private String productImages;
	/**
	 * 销量
	 */
	private Long sales;
	/**
	 * 评分
	 */
	private Float score;
	/**
	 * 评分数
	 */
	private Long scoreCount;
	/**
	 * 编号
	 */
	private String sn;
	/**
	 * 规格项
	 */
	private String specificationItems;
	/**
	 * 总评分
	 */
	private Long totalScore;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 周点击数
	 */
	private Long weekHits;
	/**
	 * 周点击数更新日期
	 */
	private Date weekHitsDate;
	/**
	 * 周销量
	 */
	private Long weekSales;
	/**
	 * 周销量更新日期
	 */
	private Date weekSalesDate;
	/**
	 * 重量
	 */
	private Integer weight;
	/**
	 * 品牌
	 */
	private Long brandId;
	/**
	 * 商品分类
	 */
	private Long productCategoryId;
	/**
	 * 店铺
	 */
	private Long storeId;
	/**
	 * 店铺商品分类
	 */
	private Long storeProductCategoryId;
	/**
	 * 默认 同步：1；不同步：0
默认 同步：1；不同步：0
	 */
	private Boolean erpFlag;
	/**
	 * 用于ERP同步商品编号-老库数据
	 */
	private String internalNumber;
	/**
	 * 是否促销商品
	 */
	private Boolean isPro;
	/**
	 * 更新标志
	 */
	private Boolean syncFlag;
	/**
	 * 门店编码
	 */
	private String storeNo;
	/**
	 * 同步时间
	 */
	private Date syncTime;
	/**
	 * 专柜编码
	 */
	private String counterNo;
	/**
	 * 专柜名称
	 */
	private String counterName;
	/**
	 * 商品提示ID
	 */
	private String noteIds;
	/**
	 * 发布商品人员ID
	 */
	private Long businessId;
	/**
	 * 
	 */
	private Date beginDate;
	/**
	 * 
	 */
	private Date endDate;
	/**
	 * 
	 */
	private Boolean isAreaLock;
	/**
	 * 
	 */
	private String areaIds;
	/**
	 * 
	 */
	private String noteContents;
	/**
	 * 
	 */
	private String businessName;
	/**
	 * 
	 */
	private Date promStartTime;
	/**
	 * 
	 */
	private Date promEndTime;
	/**
	 * 额外运费
	 */
	private BigDecimal moreFreight;
	/**
	 * ES促销标识
	 */
	private Boolean promotionFlag;
	/**
	 * ES库存标识
	 */
	private Boolean stockFlag;

}
