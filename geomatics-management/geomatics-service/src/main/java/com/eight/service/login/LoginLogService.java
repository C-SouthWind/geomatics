package com.eight.service.login;

import com.eight.base.BaseService;
import com.eight.model.login.LoginLog;
import com.eight.utils.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：chj
 * @date ：Created in 2020/5/27 17:50
 * @params :
 */
@Service
public class LoginLogService extends BaseService<LoginLog> {
    @Autowired
    private LoginLogService loginLogService;

    /** 方法描述 
    * @Description: 新增登录日志
    * @Param: [loginLog]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/6/3
    */
    public Integer loginLogInsertByLoginLog(LoginLog loginLog){
        if (NotEmpty.objectNotEmpty(loginLog)) {
            Integer integer = loginLogService.loginLogInsertByLoginLog(loginLog);
            System.out.println("222222222222222222222222"+NotEmpty.integerNotEmpty(integer));
            if (NotEmpty.integerNotEmpty(integer)) {
                return integer;
            }
        }
        return null;
    }
}
