package com.eight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：chj
 * @date ：Created in 2020/5/14 14:32
 * @params :
 */
@SpringBootApplication
@EnableEurekaServer
public class Application7082 {
    public static void main(String[] args) {
        SpringApplication.run(Application7082.class,args);
    }
}
