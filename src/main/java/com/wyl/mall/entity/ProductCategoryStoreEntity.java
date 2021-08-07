package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品分类店铺绑定
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("product_category_store")
public class ProductCategoryStoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 店铺
	 */
	@TableId
	private Long storesId;
	/**
	 * 商品分类
	 */
	private Long productCategoriesId;

}
