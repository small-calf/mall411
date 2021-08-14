package com.wyl;

import cn.hutool.crypto.SecureUtil;
import com.wyl.mall.entity.UsersEntity;

import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class Mall411ApplicationTests {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() throws ParseException {
        String filepath = System.getProperty("user.dir")+"\\resource\\";
        System.out.println(filepath);
//        redisTemplate.opsForValue().set("calf","123");
//        String calf = redisTemplate.opsForValue().get("calf");
//        System.out.println(calf);
//        cartItemService.test();
//        String aa = redisTemplate.opsForValue().get("aa::test");
//        test();
//        System.out.println(test.toString());

        String s = SecureUtil.md5("123");
        System.out.println(s);

    }
//    @Cacheable(value = {"aa","cc"},key = "#root.method")
//    public UsersEntity test() throws ParseException {
//        System.out.println(11);
//        String format = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").format(new Date());
//        return new UsersEntity("11", 2L,new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").parse(format));
//    }




}
