package com.wyl.mall.dto;/**
 * @Auther:calf
 * @Date:2021/8/10
 * @Description:mall411
 * @version:1.0
 */

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 登录
 **/
@Data
public class UserLoginDto {
    @NotBlank(message = "用户名不能为空")
    private String mobile;

    @NotBlank(message = "密码不能为空")
    private String encodedPassword;


    @NotBlank(message = "验证码不能为空")
    private String captcha;

    /**
     * 最后修改日期
     */
    private Date lastModifiedDate = new Date();
}
