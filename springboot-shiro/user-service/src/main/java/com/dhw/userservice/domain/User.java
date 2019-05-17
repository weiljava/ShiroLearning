package com.dhw.userservice.domain;


import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String phone;
    private String email;
}
