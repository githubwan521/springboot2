package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rmm on 2018/12/26.
 */
@RestController
public class IndexController {
    @Value("${server.port}")
    private int port;

    @RequestMapping("/index")
    public String index(){
        return "hello port ="+port;
    }
}
