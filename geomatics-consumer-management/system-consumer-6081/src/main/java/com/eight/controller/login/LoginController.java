package com.eight.controller.login;



import com.eight.annotation.LoginLogAnnotation;
import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.login.User;
import com.eight.service.EightService;
import com.eight.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 19:46
 * @params :
 */
@RestController
@Api(value = "登录信息",tags = "用户登录接口")
public class LoginController extends BaseController {
    @Autowired
    private EightService eightService;

    /** 方法描述
    * @Description: 执行登录操作
    * @Param: [user]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/15
    */
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录功能", notes = "用户执行登录功能")
    @LoginLogAnnotation(operationType = "登录操作",operationName = "管理员登录")
    public ResultData doLogin(User user) {
        TokenVo tokenVo = eightService.doLogin(user);
        return tokenVo.getIfSuccess()?super.loginSuccess(tokenVo.getToken()):super.loginFailed();
    }
}





























