package com.wyl.mall.shiro;/**
 * @Auther:calf
 * @Date:2021/8/5
 * @Description:mall411
 * @version:1.0
 */

import com.wyl.mall.utils.Log4jUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 **/
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Log4jUtil.info("=============================授权=================================");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Log4jUtil.info("=============================认证=================================");
        return null;
    }
}
