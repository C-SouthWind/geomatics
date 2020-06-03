package com.eight.controller.login;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.login.LoginLog;
import com.eight.service.login.LoginLogService;
import com.eight.utils.Map2BeanUtils;
import com.eight.utils.Map2Object;
import com.eight.utils.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/6/2 19:27
 * @params :
 */
@RestController
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;

    /** 方法描述
     * @Description: 添加登录日志信息
     * @Param: [map]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/27
     */
    @PostMapping("/loginAddByMap")
    public ResultData loginAddByMap(@RequestBody Map map){
        Integer add = null;
        LoginLog o =(LoginLog) Map2Object.mapToBean(map, LoginLog.class);
        try {
            add = loginLogService.add(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NotEmpty.integerNotEmpty(add) ? insertSuccess(add) : insertFailed();
    }
}
