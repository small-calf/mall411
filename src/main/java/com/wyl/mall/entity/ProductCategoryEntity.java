package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 商品分类
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("product_category")
public class ProductCategoryEntity implements Serializable {
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
	 * 排序
	 */
	private Integer orders;
	/**
	 * 普通店铺分佣比例
	 */
	private Double generalRate;
	/**
	 * 层级
	 */
	private Integer grade;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 自营店铺分佣比例
	 */
	private Double selfRate;
	/**
	 * 页面描述
	 */
	private String seoDescription;
	/**
	 * 页面关键词
	 */
	private String seoKeywords;
	/**
	 * 页面标题
	 */
	private String seoTitle;
	/**
	 * 树路径
	 */
	private String treePath;
	/**
	 * 上级分类
	 */
	private Long parentId;
	/**
	 * 库存核减数
	 */
	private Integer deductStock;
	/**
	 * 图片路径
	 */
	private String imgUrl;
	/**
	 * A,B,C分类
	 */
	private String categoryType;
	/**
	 * 是否有效
	 */
	private Boolean isEffective;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)//当这个字段不为空时才显示
	@TableField(exist = false)
	private List<ProductCategoryEntity> children;

}
