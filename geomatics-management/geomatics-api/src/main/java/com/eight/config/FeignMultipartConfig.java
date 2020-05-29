package com.eight.config;

import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：chj
 * @date ：Created in 2020/5/29 16:36
 * @params :
 */
@Configuration
public class FeignMultipartConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;


    /** 方法描述
    * @Description: 这里其实就是把springcloud的请求头编码集修改为既可以接收文件类型，又可以接收普通类型
    * @Param: []
    * @return: feign.codec.Encoder
    * @Author: chj
    * @Date: 2020/5/29
    */
    @Bean
    @ConditionalOnBean
    public feign.codec.Encoder springFormEncoder(){
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
}
