package com.eight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 16:49
 * @params :
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application6081 {
    public static void main(String[] args) {
        SpringApplication.run(Application6081.class,args);
    }
}
