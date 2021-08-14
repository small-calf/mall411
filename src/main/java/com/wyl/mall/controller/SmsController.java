package com.wyl.mall.controller;/**
 * @Auther:calf
 * @Date:2021/8/9
 * @Description:mall411
 * @version:1.0
 */

import com.wyl.mall.common.VerifyCode;
import com.wyl.mall.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * 验证码
 **/
@RestController
@RequestMapping("/sms")
public class SmsController {
    private static String captcha = "";
    /**
     *刷新验证码
     */
    @GetMapping("/captcha")
    public R smsCaptcha(HttpServletResponse response, HttpServletRequest request) {
        String randomText = "";
        try {

            int width = 200;

            int height = 69;

            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

//生成对应宽高的初始图片

            randomText = VerifyCode.drawRandomText(width, height, verifyImg);


        } catch (Exception e) {

            e.printStackTrace();

        }
        captcha = randomText;
        HashMap<String, Object> map = new HashMap<>();
        map.put("captcha",randomText);
        return R.ok().put("data", map);

    }

    /**
     * 判断验证码是否正确
     */
    public boolean interpretationCaptcha(String sms) {
        if (captcha.equals(sms)) {
            return true;
        }else {
            return false;
        }

    }


}
