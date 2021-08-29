package com.wyl.mall.utils;/**
 * @Auther:calf
 * @Date:2021/8/29
 * @Description:mall411
 * @version:1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 **/
@Component
public class TokenUtils {
    @Autowired
    private StringRedisTemplate redisTemplate;
    public String getToken(String token) {
        String userId = JWTUtil.getUsername(token);
        String redisToken = redisTemplate.opsForValue().get(userId).toString();
        if (!token.equals(redisToken)) {
            return "error";
        }
        return userId;
    }
}
