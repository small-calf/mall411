package com.wyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户
 * 
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@Data
@TableName("users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户类型
	 */
	private String dtype;
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
	 * 是否启用
	 */
	private Boolean isEnabled;
	/**
	 * 是否锁定
	 */
	private Boolean isLocked;
	/**
	 * 最后登录日期
	 */
	private Date lastLoginDate;
	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;
	/**
	 * 锁定日期
	 */
	private Date lockDate;
	/**
	 * 部门
	 */
	private String department;
	/**
	 * E-mail
	 */
	private String email;
	/**
	 * 加密密码
	 */
	private String encodedPassword;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 商家注册项值0
	 */
	private String attributeValue0;
	/**
	 * 商家注册项值1
	 */
	private String attributeValue1;
	/**
	 * 商家注册项值10
	 */
	private String attributeValue10;
	/**
	 * 商家注册项值11
	 */
	private String attributeValue11;
	/**
	 * 商家注册项值12
	 */
	private String attributeValue12;
	/**
	 * 商家注册项值13
	 */
	private String attributeValue13;
	/**
	 * 商家注册项值14
	 */
	private String attributeValue14;
	/**
	 * 商家注册项值15
	 */
	private String attributeValue15;
	/**
	 * 商家注册项值16
	 */
	private String attributeValue16;
	/**
	 * 商家注册项值17
	 */
	private String attributeValue17;
	/**
	 * 商家注册项值18
	 */
	private String attributeValue18;
	/**
	 * 商家注册项值19
	 */
	private String attributeValue19;
	/**
	 * 商家注册项值2
	 */
	private String attributeValue2;
	/**
	 * 商家注册项值3
	 */
	private String attributeValue3;
	/**
	 * 商家注册项值4
	 */
	private String attributeValue4;
	/**
	 * 商家注册项值5
	 */
	private String attributeValue5;
	/**
	 * 商家注册项值6
	 */
	private String attributeValue6;
	/**
	 * 商家注册项值7
	 */
	private String attributeValue7;
	/**
	 * 商家注册项值8
	 */
	private String attributeValue8;
	/**
	 * 商家注册项值9
	 */
	private String attributeValue9;
	/**
	 * 余额
	 */
	private BigDecimal balance;
	/**
	 * 银行账号
	 */
	private String bankAccount;
	/**
	 * 银行开户名
	 */
	private String bankName;
	/**
	 * 冻结金额
	 */
	private BigDecimal frozenAmount;
	/**
	 * 法人代表身份证
	 */
	private String idCard;
	/**
	 * 法人代表身份证图片
	 */
	private String idCardImage;
	/**
	 * 纳税人识别号
	 */
	private String identificationNumber;
	/**
	 * 法人代表姓名
	 */
	private String legalPerson;
	/**
	 * 营业执照号图片
	 */
	private String licenseImage;
	/**
	 * 营业执照号
	 */
	private String licenseNumber;
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	/**
	 * 组织机构代码证图片
	 */
	private String organizationImage;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 过期时间
	 */
	private Date safeKeyExpire;
	/**
	 * 密钥
	 */
	private String safeKeyValue;
	/**
	 * 税务登记证图片
	 */
	private String taxImage;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 消费金额
	 */
	private BigDecimal amount;
	/**
	 * 头像
	 */
	private String avatarUrl;
	/**
	 * 出生日期
	 */
	private Date birth;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 积分
	 */
	private BigDecimal point;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 地区
	 */
	private Long areaId;
	/**
	 * 会员等级
	 */
	private Long memberRankId;
	/**
	 * 小象电商年度积分
	 */
	private BigDecimal apoints;
	/**
	 * 小象电商积分
	 */
	private BigDecimal points;
	/**
	 * 数据来源
	 */
	private Integer dataSource;

}
