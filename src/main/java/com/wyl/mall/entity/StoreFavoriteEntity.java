package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 店铺收藏
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("store_favorite")
public class StoreFavoriteEntity implements Serializable {
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
	 * 店铺
	 */
	private Long storeId;

}
