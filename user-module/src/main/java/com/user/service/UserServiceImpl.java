package com.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.order.OrderApi;
import com.user.UserApi;
import org.springframework.stereotype.Service;

@Service
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0.0",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        application = "${dubbo.application.id}",
        group = "dubbo",
        weight = 20
)
public class UserServiceImpl implements UserApi {
    @Reference(
            version = "1.0.0",
            group = "dubbo",
            check = false
    )
    private OrderApi orderApi;

    @Override
    public String getUserOrderInfo(String userId) {
        System.out.println("UserServiceImpl 向 orderApi.getOrderInfo 发请求，参数：" + userId);
        return orderApi.getOrderInfo(userId);
    }
}
