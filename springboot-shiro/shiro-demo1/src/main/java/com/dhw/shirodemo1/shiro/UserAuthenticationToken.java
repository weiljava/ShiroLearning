package com.dhw.shirodemo1.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserAuthenticationToken extends UsernamePasswordToken {

    public UserAuthenticationToken(String username, String password, boolean rememberMe) {
        super(username, password, rememberMe);
    }
}