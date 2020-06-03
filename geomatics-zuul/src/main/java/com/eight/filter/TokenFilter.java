package com.eight.filter;

import com.eight.utils.GetParamsUtils;
import com.eight.utils.PostParamsUtils;
import com.eight.utils.SendParams2ControllerUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：chj
 * @date ：Created in 2020/6/2 17:17
 * @params :
 */
@Component
public class TokenFilter extends ZuulFilter {
    /** 方法描述
    * @Description:
     *                  1.pre
     *                      到达路由之前执行
     *                  2.routing
     *                      到达路由的时候执行
     *                  3.post
     *                      在路由之后执行
     *                  4.error
     *                      在路由抛出异常的时候执行
     *
    * @Param: []
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/6/2
    */
    public String filterType() {
        return "pre";
    }

    /** 方法描述 
    * @Description: 过滤器的加载顺序
     *                     数字越大越低
    * @Param: []
    * @return: int
    * @Author: chj
    * @Date: 2020/6/2
    */
    public int filterOrder() {
        return 0;
    }

    /** 方法描述 
    * @Description: 是否启用过滤器
    * @Param: []
    * @return: boolean
    * @Author: chj
    * @Date: 2020/6/2
    */
    public boolean shouldFilter(){
        //拿到当前request对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //获取GET方式请求的参数
        String params = GetParamsUtils.getParams(request);
        //判断是否有token
        if (params.contains("token") && params.contains("http://") || params.contains("https://")) {
            return true;
        }
        SendParams2ControllerUtils.sendPanras(PostParamsUtils.postParams(currentContext),currentContext,request);
        return false;
    }

    /** 方法描述 
    * @Description: 验证token的业务在这里执行
    * @Param: []
    * @return: java.lang.Object
    * @Author: chj
    * @Date: 2020/6/2
    */
    public Object run() throws ZuulException {
        return null;
    }
}
