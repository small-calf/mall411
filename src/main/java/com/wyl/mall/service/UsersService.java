package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.dto.*;
import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;

import java.util.Map;

/**
 * 用户
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface UsersService extends IService<UsersEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R regMember(UserMemberRegDto userMember);

    R regBusiness(UserBusinessRegDto userBusiness);

    R login(UserLoginDto userLogin);

    UsersEntity selectBusiness(String mobile);

    UsersEntity selectUser(String mobile);

    R updatePassword(UserUpdatePasswordDto userUpdatePassword, String token);

    R forgetPassword(UserLoginDto userLogin);

    R getUserInfo(Long id);

    R updateUsersInfo(UsersEntity userInfo, String token);

    R quiteLogin(String id, String token);
}

