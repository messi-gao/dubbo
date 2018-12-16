package com.order.service;

import com.order.OrderApi;
import org.springframework.stereotype.Service;

@Service
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        group = "dubbo")
public class OrderApiImpl implements OrderApi {
    @Override
    public String getOrderInfo(String userId) {
        System.out.println("OrderApiImpl getOrderInfo :" + userId);
        return "getOrderInfo" + userId;
    }
}
