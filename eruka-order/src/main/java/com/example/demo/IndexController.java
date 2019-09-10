package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Rmm on 2018/12/28.
 */

@RestController
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;

    //    在springcloud里边的两种调用方式，一种是springcloud(feign),rest
    //订单服务调用会员服务
    @RequestMapping("/indexorder")
    public String getOrder1() {
        //
        String memberUrl = "http://app-xiyou.member/index";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;
    }

    @RequestMapping("/getOrder")
    public String getOrder() {
        //order使用rpc远程调用技术，调用会员服务
        String result = restTemplate.getForObject("http://127.0.0.1:8080/index", String.class);
        System.out.println("订单服务调用会员服务 " + result);
        return result;
    }
}
