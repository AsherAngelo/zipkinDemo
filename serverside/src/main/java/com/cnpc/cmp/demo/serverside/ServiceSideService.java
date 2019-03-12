package com.cnpc.cmp.demo.serverside;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("demo-customer")
public interface ServiceSideService {

    @RequestMapping("/hello")
    public String hello();

    @RequestMapping("/helloV2")
    public String helloV2(@RequestParam("strrr") String strrr);
}
