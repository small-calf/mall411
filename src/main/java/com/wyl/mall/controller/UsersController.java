package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.dto.*;
import com.wyl.mall.utils.JWTUtil;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import com.wyl.mall.utils.UploadAvatar;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.service.UsersService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * 用户
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 普通用户注册
     */
    @PostMapping("/regMember")
    public R regMember(@Valid @RequestBody UserMemberRegDto userMember) {
        UsersEntity users =  usersService.selectUser(userMember.getMobile());
        if (users != null) {
            return R.error(401,"该用户已被注册");
        }
        R r = usersService.regMember(userMember);
        return r;
    }
    /**
     * 商家注册
     */
    @PostMapping("/regBusiness")
    public R regBusiness(@Valid @RequestBody UserBusinessRegDto userBusiness) {
        UsersEntity users =  usersService.selectBusiness(userBusiness.getMobile());
        if (users != null) {
            return R.error(401,"该用户已被注册");
        }
        R r = usersService.regBusiness(userBusiness);
        return r;
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public R login(@Valid @RequestBody UserLoginDto userLogin) {
        R r = usersService.login(userLogin);
        return r;
    }

    /**
     * 修改密码
     */
    @PostMapping("/updatePassword")
    public R updatePassword(@Valid @RequestBody UserUpdatePasswordDto userUpdatePassword,
                            HttpServletRequest request) {
        String token = request.getHeader("token");
        R r =usersService.updatePassword(userUpdatePassword,token);
        return r;
    }

    /**
     * 忘记密码
     */
    @PostMapping("/forgetPassword")
    public R forgetPassword(@Valid @RequestBody UserLoginDto userLogin) {
        R r = usersService.forgetPassword(userLogin);
        return r;
    }

    /**
     * 个人信息展示
     */
    @GetMapping("/getUserInfo")
    public R getUserInfo(@RequestParam("id") Long id) {
        R r = usersService.getUserInfo(id);
        return r;
    }

    /**
     * 修改个人信息
     */
    @PostMapping("/updateUsersInfo")
    public R updateUsersInfo(UserInfoDto userInfo,
                             @RequestParam("file") MultipartFile file,
                             HttpServletRequest request) {
        String filepath = System.getProperty("user.dir")+"\\src\\main\\resources\\avatar\\";
        //上传头像
        UploadAvatar.uploadPhoto(filepath, file);

        UsersEntity usersEntity = new UsersEntity();
        BeanUtils.copyProperties(userInfo,usersEntity);
        usersEntity.setAvatarUrl(file.getOriginalFilename());

        String token = request.getHeader("token");
        R r = usersService.updateUsersInfo(usersEntity,token);
        return r;
    }
    /**
     * 退出登录
     */
    @GetMapping("/quiteLogin")
    public R quiteLogin(@RequestParam("id")String id, HttpServletRequest request) {
        String token = request.getHeader("token");
        R r = usersService.quiteLogin(id,token);
        return r;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:users:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:users:info")
    public R info(@PathVariable("id") Long id){
		UsersEntity users = usersService.getById(id);

        return R.ok().put("users", users);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:users:save")
    public R save(@RequestBody UsersEntity users){
		usersService.save(users);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:users:update")
    public R update(@RequestBody UsersEntity users){
		usersService.updateById(users);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:users:delete")
    public R delete(@RequestBody Long[] ids){
		usersService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
