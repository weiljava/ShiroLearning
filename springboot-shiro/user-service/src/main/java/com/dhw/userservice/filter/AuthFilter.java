package com.dhw.userservice.filter;

import com.dhw.userservice.domain.User;
import com.dhw.userservice.handler.UserHandler;
import lombok.extern.java.Log;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest)servletRequest;


        User user=UserHandler.getUser();

        if(user==null){
            user=new User();
            user.setId(99);
            user.setName("dhw");
            user.setPhone("15005188090");
            UserHandler.setUser(user);

            log.info("filter save user to threadlocal");
        }

    }
}
