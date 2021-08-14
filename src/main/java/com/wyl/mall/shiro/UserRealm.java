package com.wyl.mall.shiro;/**
 * @Auther:calf
 * @Date:2021/8/5
 * @Description:mall411
 * @version:1.0
 */

import com.wyl.mall.jwt.JWTToken;
import com.wyl.mall.utils.JWTUtil;
import com.wyl.mall.utils.Log4jUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 **/
public class UserRealm extends AuthorizingRealm {
//    @Resource
//    private EmployeeService employeeService;

    /**
     * 必须重写此方法，否则会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JWTToken;
    }
    /**
     * 授权方法
     * @param principalCollection principal的集合，可以理解为各种用户身份的集合，比如用户名、邮箱、手机号等
     * @return 返回的是授权信息，包括角色与权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Log4jUtil.info("=============================授权=================================");
        String username = JWTUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        List<Roles> roles = employeeService.getAllRolesByEmpName(username);
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
//        for (Roles role : roles) {
//            roleSet.add(role.getRoleName());
//        }
//        List<Permission> permissions = employeeService.getAllPermissionsByEmpName(username);
//        for (Permission permission : permissions) {
//            permissionSet.add(permission.getPermName());
//        }
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }

    /**
     * 这个方法用于认证
     * @param authenticationToken 用户名与密码
     * @return 认证信息
     * @throws AuthenticationException 可能引发的异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Log4jUtil.info("=============================认证=================================");
        //获得token
        String token = (String) authenticationToken.getCredentials();
        //从token中获得username
        String username = JWTUtil.getUsername(token);
        //如果username为空或者验证不匹配
        if(username == null||!JWTUtil.verify(token,username)){
            throw new AuthenticationException("token认证失败!");
        }
//        String password = employeeService.getPassword(username);
        //如果没有查询到用户名对应的密码
//        if(password==null){
//            throw new AuthenticationException("该用户不存在");
//        }
        return new SimpleAuthenticationInfo(token,token,"MyRealm");
    }
}
