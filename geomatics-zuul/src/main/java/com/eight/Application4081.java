package com.eight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：chj
 * @date ：Created in 2020/6/2 17:13
 * @params :
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(basePackages = {"com.eight"})
public class Application4081 {
    public static void main(String[] args) {
        SpringApplication.run(Application4081.class,args);
    }
}
