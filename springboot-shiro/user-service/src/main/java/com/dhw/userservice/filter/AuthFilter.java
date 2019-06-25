package com.dhw.userservice.filter;

import com.dhw.userservice.domain.User;
import com.dhw.userservice.handler.UserHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

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

    @Override
    public void destroy() {

    }
}
