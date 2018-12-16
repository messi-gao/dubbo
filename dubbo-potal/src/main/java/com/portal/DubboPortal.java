package com.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dubbo.xml"})
public class DubboPortal {
    public static void main(String[] args) {
        SpringApplication.run(DubboPortal.class, args);
    }
}
