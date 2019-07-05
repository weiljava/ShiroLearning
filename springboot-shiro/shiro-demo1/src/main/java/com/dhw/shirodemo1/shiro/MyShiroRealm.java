package com.dhw.shirodemo1.shiro;

import com.dhw.shirodemo1.exception.UserException;
import com.dhw.shirodemo1.model.domain.UserInfo;
import com.dhw.shirodemo1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 9:13
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    public String getName() {
        return "com.dhw.shirodemo1.shiro.MyShiroRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info(principals.getPrimaryPrincipal().toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        if (token instanceof UserAuthenticationToken) {
            UserAuthenticationToken userAuthenticationToken = (UserAuthenticationToken) token;
            String userName = userAuthenticationToken.getUsername();
            UserInfo userInfo = userService.getUserByLoginName(userName);
            if (userInfo == null) {
                throw new UnknownAccountException(); //如果用户名错误
            }
            String password = String.valueOf(userAuthenticationToken.getPassword());
            userInfo = userService.getUserByLoginNameAndPwd(userName, password);
            if (userInfo == null) {
                throw new IncorrectCredentialsException(); //如果密码错误
            } else {
                //如果身份认证验证成功，返回一个AuthenticationInfo实现；
                info = new SimpleAuthenticationInfo(userName, password, getName());
            }
        }
        return info;
    }
}