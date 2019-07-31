package com.dhw.userservice.controller;


import com.dhw.userservice.domain.User;
import com.dhw.userservice.handler.UserHandler;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Log
public class HelloController {


    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {

        return "Hello,".concat(name).concat("!");
    }


    @PostMapping("/testHandler")
    public String testHandler(int num) {
        User user=UserHandler.getUser();

        if(user==null){
            user=new User();
            user.setId(99);
            user.setName("dhw");
            user.setPhone("15005188090");
            UserHandler.setUser(user);

            log.info("save user to threadlocal");
        }


        for (int i = 0; i < num; i++) {
            User currentUser = UserHandler.getUser();
            log.info("原始用户ID：" + currentUser.getId());


            User tempUser = new User();
            tempUser.setId(i);
            tempUser.setName("test" + i);
            UserHandler.setUser(tempUser);
            log.info("修改后的用户ID" + UserHandler.getUser().getId());


            UserHandler.setUser(currentUser);
            log.info("重制回去的用户ID:" + UserHandler.getUser().getId());

            log.info("===================华丽分割线========================");
        }


        return "success";
    }



    @GetMapping("/test/head")
    public String testGatewayHead(HttpServletRequest request){
        log.info("调用user-service");
        String head=request.getHeader("loginName");
        return "return head info:"+head;
    }
}
