package com.order;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.order.service")
public class OrderProvider {
    public static void main(String[] args) {
        SpringApplication.run(OrderProvider.class, args);
    }
}
