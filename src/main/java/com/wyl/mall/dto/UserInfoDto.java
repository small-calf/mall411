package com.wyl.mall.dto;/**
 * @Auther:calf
 * @Date:2021/8/14
 * @Description:mall411
 * @version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private Long id;

    private String email;//邮箱

    private String username;//用户名

    private String avatarUrl;//头像

    private Date birth;//生日

    private Integer gender;//性别 0:男 1:女

    private Integer point = 0;//积分

    private String zipCode;//邮编

    private Integer memberRankId = 1;//会员等级 1:普通会员 2:银牌会员 3：金牌会员 4：钻石会员
}
