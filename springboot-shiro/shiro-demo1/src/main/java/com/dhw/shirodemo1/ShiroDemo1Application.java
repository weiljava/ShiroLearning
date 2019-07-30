package com.dhw.shirodemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan ("com.dhw.shirodemo1.dao")
public class ShiroDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemo1Application.class, args);
    }

}
