package com.eight.utils;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.ServletInputStreamWrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * @author ：chj
 * @date ：Created in 2020/6/2 17:46
 * @params :    从zuul发送数据到达controller
 */
public class SendParams2ControllerUtils {

    private SendParams2ControllerUtils(){

    }

    /** 方法描述
    * @Description: 发送数据的方法
    * @Param: [bodyJson, rcx, request]
    * @return: void
    * @Author: chj
    * @Date: 2020/6/2
    */
    public static void sendPanras(final JSONObject bodyJson, RequestContext rcx, HttpServletRequest request){
        String body = bodyJson.toString();
        //把String转换为字节数组
        final byte[] bodyBytes = body.getBytes();
        //把request放到当前的上下文对象中
        rcx.setRequest(new HttpServletRequestWrapper(request){
            @Override
            public ServletInputStream getInputStream() throws IOException {
                return new ServletInputStreamWrapper(bodyBytes);
            }

            @Override
            public int getContentLength() {
                return bodyBytes.length;
            }

            @Override
            public long getContentLengthLong() {
                return bodyBytes.length;
            }
        });
    }
}
