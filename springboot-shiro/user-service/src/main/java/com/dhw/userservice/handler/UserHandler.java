package com.dhw.userservice.handler;

import com.dhw.userservice.domain.User;

public class UserHandler {

    private static final ThreadLocal<User> threadLocal=new ThreadLocal<User>();



    public static void setUser(User user){
        threadLocal.set(user);
    }

    public static User getUser(){
        return threadLocal.get();
    }


}
