package com.wyl.mall.dto;/**
 * @Auther:calf
 * @Date:2021/8/14
 * @Description:mall411
 * @version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatePasswordDto {

    @NotBlank(message = "用户名不能为空")
    private String mobile;

    @NotBlank(message = "密码不能为空")
    private String oldPassword;

    @NotBlank(message = "密码不能为空")
    private String encodedPassword;
}
