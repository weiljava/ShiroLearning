package com.dhw.shirodemo1.shiro;

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 9:13
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Log4j2
public class MyShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info(principals.getPrimaryPrincipal().toString());

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = "";
        String pwd = "123";//模拟从其他地方获取密码信息
        if (token instanceof UserAuthenticationToken) {
            UserAuthenticationToken userAuthenticationToken = (UserAuthenticationToken) token;
            userName = userAuthenticationToken.getUsername();
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    new SimpleAuthenticationInfo(userName, pwd, "myShiroRealm");
            return simpleAuthenticationInfo;
        }
        return null;
    }
}