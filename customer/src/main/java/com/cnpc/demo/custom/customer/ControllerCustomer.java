package com.cnpc.demo.custom.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ControllerCustomer {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/helloV2")
    public String helloV2(String strrr){
        return new Date().toString()+"我是测试时间:"+strrr;
    }
}
