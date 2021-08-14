package com.wyl.mall.jwt;/**
 * @Auther:calf
 * @Date:2021/8/9
 * @Description:mall411
 * @version:1.0
 */

import org.apache.shiro.authc.AuthenticationToken;

/**
 **/
public class JWTToken implements AuthenticationToken {
    private String token;
    public JWTToken(String token){
        this.token = token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
