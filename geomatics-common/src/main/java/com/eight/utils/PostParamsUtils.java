package com.eight.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.ServletInputStream;
import java.io.IOException;

/**
 * @author ：chj
 * @date ：Created in 2020/6/2 17:56
 * @params :       获取POST请求方式的参数
 */
public class PostParamsUtils {
    
    private PostParamsUtils(){
        
    }
    /** 方法描述 
    * @Description: 获取参数的方法
    * @Param: [rcx]
    * @return: com.alibaba.fastjson.JSONObject
    * @Author: chj
    * @Date: 2020/6/2
    */
    public static JSONObject postParams(RequestContext rcx){
        //body置空
        String body = null;
        if (!rcx.isChunkedRequestBody()) {
            ServletInputStream inp;
            try {
                inp = rcx.getRequest().getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return JSON.parseObject(body);
    }
}
