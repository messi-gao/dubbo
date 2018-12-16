package com.portal.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.user.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class UserPotalController {
    @Autowired
    private ApplicationContext context;
    //    @Reference(
//            version = "1.0.0",
//            group = "dubbo",
//            check = false,
//            cluster = "failover",
//            loadbalance = "random",
//            cache = "lru",
//            async = true
//    )
    @Autowired
    private UserApi userServiceImpl;

    @GetMapping("/getUserOrderInfo/{userId}")
    public ResponseEntity<String> getUserOrderInfo(@PathVariable("userId") String userId) throws ExecutionException, InterruptedException {
        String userOrderInfo = userServiceImpl.getUserOrderInfo(userId);
        Future<String> future = RpcContext.getContext().getFuture();
        userOrderInfo = future.get();
        return new ResponseEntity(userOrderInfo, HttpStatus.OK);
    }

    public void onreturn(String result, String param) {
        System.out.println("result:" + result);
        System.out.println("param:" + param);
    }

    public void onthrow(Throwable t, String param) {
        System.out.println("Throwable:" + t);
        System.out.println("param:" + param);
    }

    @GetMapping("/getUserOrderInfo/generic/{userId}")
    public ResponseEntity<String> getUserOrderInfoByGeneric(@PathVariable("userId") String userId) throws ExecutionException, InterruptedException {
        GenericService genericService = (GenericService) context.getBean("genericServiceImpl");
        String userOrderInfo = genericService.$invoke("getUserOrderInfo", new String[]{"java.lang.String"}, new Object[]{userId}).toString();
        return new ResponseEntity(userOrderInfo, HttpStatus.OK);
    }
}
