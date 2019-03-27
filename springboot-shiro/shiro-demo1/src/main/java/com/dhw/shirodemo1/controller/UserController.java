package com.dhw.shirodemo1.controller;

import com.dhw.shirodemo1.dto.req.LoginReq;
import com.dhw.shirodemo1.shiro.UserAuthenticationToken;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 9:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@Log4j2
public class UserController {

    @PostMapping ("/login")
    @ResponseBody
    public String login(@RequestBody LoginReq loginReq) {
        String result = "";
        log.info("用户登陆");
        Subject currentUser = SecurityUtils.getSubject();
        UserAuthenticationToken token = new UserAuthenticationToken(loginReq.getUserName(), loginReq.getPwd(), false);
        try {
            currentUser.login(token);
            result = "success";
        } catch (AuthenticationException e) {
            log.error(e.getMessage(), e);
            result = "fail";
        }
        return result;
    }
}