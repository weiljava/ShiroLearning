package com.dhw.shirodemo1.controller;

import com.dhw.shirodemo1.model.req.LoginReq;
import com.dhw.shirodemo1.model.resp.Result;
import com.dhw.shirodemo1.shiro.UserAuthenticationToken;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 9:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@Slf4j
public class UserController {

    @PostMapping ("/login")
    @ResponseBody
    public Result login(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult) {
        log.info("用户登陆");
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setCode("100002");
            return result;
        }

        Subject currentUser = SecurityUtils.getSubject();
        UserAuthenticationToken token = new UserAuthenticationToken(loginReq.getUserName(), loginReq.getPwd(), false);
        try {
            currentUser.login(token);
            result.setCode("100000");
            result.setMsg("登陆成功");
        } catch (AuthenticationException e) {
            log.error(e.getMessage(), e);
            result.setCode("100003");
            result.setMsg("登陆失败");
        }
        return result;
    }
}