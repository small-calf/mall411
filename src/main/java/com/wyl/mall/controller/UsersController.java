package com.wyl.mall.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.common.VerifyCode;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.service.UsersService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
     * 注册
     */
    @GetMapping("/reg")
    public R reg(HttpServletResponse response, HttpServletRequest request) {
        String randomText = "";
        try {

            int width=200;

            int height=69;

            BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

//生成对应宽高的初始图片

            randomText = VerifyCode.drawRandomText(width,height,verifyImg);

//单独的一个类方法，出于代码复用考虑，进行了封装。

//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符

//            request.getSession().setAttribute("verifyCode", randomText);

//            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

            OutputStream os = response.getOutputStream(); //获取文件输出流

//           ImageIO.write(verifyImg, "png", os);//输出图片流

//            os.flush();

//            os.close();//关闭流

        } catch (IOException e) {


            e.printStackTrace();

        }
        return R.ok().put("yzm",randomText);

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
