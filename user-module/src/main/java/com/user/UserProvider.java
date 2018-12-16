package com.user;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.user.service")
public class UserProvider {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider.class, args);
    }
}
