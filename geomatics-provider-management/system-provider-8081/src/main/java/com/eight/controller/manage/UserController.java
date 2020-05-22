package com.eight.controller.manage;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.login.User;
import com.eight.redis.RedisService;
import com.eight.service.manage.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/22 15:09
 * @params :
 */
@RestController
@RequestMapping("/manage")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /** 方法描述
    * @Description:
    * @Param: [map, redisService]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/userSelectPage")
    public ResultData userSelectPage(@RequestParam Map map){
        PageInfo<User> userPageInfo = userService.userSelectPage(map, redisService);
        if (null == userPageInfo) {
            return selectFailed();
        }
        return selectSuccess(userPageInfo);
    }

}
