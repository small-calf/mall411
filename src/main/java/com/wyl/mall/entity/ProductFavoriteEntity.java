package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品收藏
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-07 15:28:06
 */
@Data
@TableName("product_favorite")
public class ProductFavoriteEntity implements Serializable {
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
	 * 会员
	 */
	private Long memberId;
	/**
	 * 商品
	 */
	private Long productId;

}
