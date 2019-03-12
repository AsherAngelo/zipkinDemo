package com.cnpc.cmp.demo.serverside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ServiceSideService serviceSideService;

    @RequestMapping("/str")
    public String str(){
        return serviceSideService.hello();
    }

    @RequestMapping("/strV2")
    public String strV2(String str){
        return serviceSideService.helloV2(str);
    }
}
