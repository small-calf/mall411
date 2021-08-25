package com.wyl.mall.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.wyl.mall.controller.SmsController;
import com.wyl.mall.dto.*;
import com.wyl.mall.utils.JWTUtil;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.UsersDao;
import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.service.UsersService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;


@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private UsersDao usersDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsersEntity> page = this.page(
                new Query<UsersEntity>().getPage(params),
                new QueryWrapper<UsersEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 注册普通用户
     * @param userMember
     * @return
     */
    @Override
    public R regMember(UserMemberRegDto userMember) {
        Long id = IdWorker.getId();
        UsersEntity usersEntity = new UsersEntity();

        if (!userMember.getEncodedPassword().equals(userMember.getOncePassword())) {
            return R.error(401,"密码不一致");
        }


        //加密
        String password = SecureUtil.md5(userMember.getEncodedPassword());


        BeanUtils.copyProperties(userMember,usersEntity);

        usersEntity.setEncodedPassword(password);
        usersEntity.setDtype("Member");
        usersEntity.setId(id);
        String token = JWTUtil.createToken(id.toString());

        redisTemplate.opsForValue().set(id.toString(),token,10, TimeUnit.DAYS );

        //检查验证码
        boolean b = new SmsController().interpretationCaptcha(userMember.getCaptcha());
        if (!b) {
            return R.error(401,"验证码错误");
        }
        usersDao.insert(usersEntity);
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("id",id);
        return R.ok().put("data",map);
    }

    /**
     * 注册商家
     * @param userBusiness
     * @return
     */
    @Override
    public R regBusiness(UserBusinessRegDto userBusiness) {
        Long id = IdWorker.getId();
        String businessId = id.toString().substring(0,8);

        UsersEntity usersEntity = new UsersEntity();

        if (!userBusiness.getEncodedPassword().equals(userBusiness.getOncePassword())) {
            return R.error(401,"密码不一致");
        }


        //加密
        String password = SecureUtil.md5(userBusiness.getEncodedPassword());


        BeanUtils.copyProperties(userBusiness,usersEntity);

        usersEntity.setEncodedPassword(password);
        usersEntity.setDtype("Business");
        usersEntity.setId(Long.parseLong(businessId));
        String token = JWTUtil.createToken(id.toString());

        //将token存在redis中
        redisTemplate.opsForValue().set(businessId,token,10, TimeUnit.DAYS );

        //检查验证码
        boolean b = new SmsController().interpretationCaptcha(userBusiness.getCaptcha());
        if (!b) {
            return R.error(401,"验证码错误");
        }
        usersDao.insert(usersEntity);
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("id",Long.parseLong(businessId));
        return R.ok().put("data",map);
    }

    /**
     * 登录
     * @param userLogin
     * @return
     */
    @Override
    public R login(UserLoginDto userLogin) {
        boolean b = new SmsController().interpretationCaptcha(userLogin.getCaptcha());
        if (!b) {
            return R.error(401,"验证码错误");
        }

        String password = SecureUtil.md5(userLogin.getEncodedPassword());
        QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",userLogin.getMobile());
        queryWrapper.eq("encoded_password",password);
        queryWrapper.eq("dtype","Member");
        UsersEntity usersEntity = usersDao.selectOne(queryWrapper);

        if (usersEntity == null) {
            return R.error(401,"用户名或密码错误");
        }

        String token = JWTUtil.createToken(usersEntity.getId().toString());

        //将token存在redis中
        redisTemplate.opsForValue().set(usersEntity.getId().toString(),token,10, TimeUnit.DAYS );

        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("id",usersEntity.getId().toString());

        return R.ok().put("data",map);
    }

    @Override
    public UsersEntity selectBusiness(String mobile) {
        QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<UsersEntity>().eq("mobile", mobile).eq("dtype","Business");
        UsersEntity usersEntity = usersDao.selectOne(queryWrapper);
        return usersEntity;
    }

    @Override
    public UsersEntity selectUser(String mobile) {
        QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<UsersEntity>().eq("mobile", mobile).eq("dtype", "Member");
        UsersEntity usersEntity = usersDao.selectOne(queryWrapper);
        return usersEntity;
    }

    @Override
    public R updatePassword(UserUpdatePasswordDto userUpdatePassword, String token) {
        String userId = JWTUtil.getUsername(token);
        //判断新密码与旧密码是否一致
        QueryWrapper<UsersEntity> usersWrapper = new QueryWrapper<UsersEntity>().eq("id", userId).eq("dtype","Member");
        UsersEntity usersEntity = usersDao.selectOne(usersWrapper);
        if (usersEntity == null) {
            return R.error(403,"用户权限错误");
        }
        //判断旧密码是否正确
        String oldPassword = SecureUtil.md5(userUpdatePassword.getOldPassword());
        if (!usersEntity.getEncodedPassword().equals(oldPassword)) {
            return R.error(401,"密码错误");
        }
        //判断新密码与旧密码是否相同
        String encodePassword = SecureUtil.md5(userUpdatePassword.getEncodedPassword());
        if (usersEntity.getEncodedPassword().equals(encodePassword)) {
            return R.error(401,"新密码不能与旧密码相同");
        }
        //修改密码
        usersEntity.setEncodedPassword(encodePassword);
        usersDao.updateById(usersEntity);

        return R.ok();
    }

    @Override
    public R forgetPassword(UserLoginDto userLogin) {
        QueryWrapper<UsersEntity> usersWrapper = new QueryWrapper<UsersEntity>().eq("mobile",userLogin.getMobile()).eq("dtype","Member");
        UsersEntity usersEntity = usersDao.selectOne(usersWrapper);
        if (usersEntity == null) {
            return R.error(401,"用户不存在");
        }

        //修改密码
        String encodePassword = SecureUtil.md5(userLogin.getEncodedPassword());
        usersEntity.setEncodedPassword(encodePassword);
        usersDao.update(usersEntity,usersWrapper);
        return R.ok();
    }

    @Override
    public R getUserInfo(Long id) {
        QueryWrapper<UsersEntity> usersWrapper = new QueryWrapper<UsersEntity>().eq("id",id).eq("dtype","Member");
        UsersEntity usersEntity = usersDao.selectOne(usersWrapper);
        if (usersEntity == null) {
            return R.error(401,"当前用户不存在");
        }
        return R.ok().put("data",usersEntity);
    }

    /**
     * 完善用户信息
     * @param userInfo
     * @param token
     * @return
     */
    @Override
    public R updateUsersInfo(UsersEntity userInfo, String token) {
        Boolean b = JWTUtil.verify(token, String.valueOf(userInfo.getId()));

        if (!b) {
            return R.error(403,"用户权限错误");
        }
        UsersEntity usersEntity = new UsersEntity();
        BeanUtils.copyProperties(userInfo,usersEntity);

        //修改信息
        usersDao.updateById(usersEntity);
        return R.ok();
    }

    @Override
    public R quiteLogin(String id, String token) {
        String redisToken = redisTemplate.opsForValue().get(id);
        if (!redisToken.equals(token)) {
            return R.error(403,"权限错误");
        }
        redisTemplate.delete(id);
        return R.ok();
    }

}