package com.eight.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author ：chj
 * @date ：Created in 2020/6/2 17:28
 * @params :        获取GET方式请求的参数
 */
public class GetParamsUtils {
    
    private GetParamsUtils(){
        
    }
    
    /** 方法描述 
    * @Description: 获取参数的方法
    * @Param: [request]
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/6/2
    */
    public static String getParams(HttpServletRequest request){
        // GET传参的形式:localhost:8081/login?username=zhangsan&password=123456
        StringBuilder params = new StringBuilder("?");

        //获取所有用户名
        Enumeration<String> names = request.getParameterNames();
        //判断用户使用的是不是get请求
        if (request.getMethod().toUpperCase().equals("GET")) {
            //循环枚举
            while (names.hasMoreElements()){
                //拿到参数的ket
                String name = names.nextElement();
                params.append(name);
                params.append("=");
                params.append(request.getParameter(name));
                params.append("&");
            }
        }

        //拼接之后 最后一位会多出来一个&
        if (params.length()>1) {
            params.delete(params.length()-1,params.length());
        }
        return params.toString();
    }
}
