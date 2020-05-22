package com.eight.controller.manage;

import com.eight.base.ResultData;
import com.eight.model.login.User;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/22 19:54
 * @params :
 */
@RestController
@Api(value = "系统管理 -->用户管理" ,tags = "用户管理接口")
public class UserController {
    @Autowired
    private EightService eightService;

    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                      根据user表 密码重置
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userResetPassword")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "密码重置")
    public ResultData userResetPassword(@RequestBody User user){
        return eightService.userResetPassword(user);
    }


    /** 方法描述
    * @Description: 系统管理 -->用户管理  条件分页查询
    * @Param: [map]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/userSelectPage")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "条件分页查询")
    ResultData userSelectPage(@RequestParam Map map){
         return eightService.userSelectPage(map);
    }


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                  根据user表对象删除用户
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userDeleteByuser")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据user表对象删除用户")
    ResultData userDeleteByuser(@RequestBody User user){
            return eightService.userDeleteByuser(user);
    }


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                      根据user表对象新增用户
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userInsertByUser")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据user表对象新增用户")
    ResultData userInsertByUser(@RequestParam User user){
        return eightService.userInsertByUser(user);
    }


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                      根据user表  查询单个信息
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userSelectOneByUser")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据user表  查询单个信息")
    ResultData userSelectOneByUser(@RequestBody User user){
        return eightService.userSelectOneByUser(user);
    }


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                  根据user表  修改信息
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userUpdateByUser")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据user表  修改信息")
    ResultData userUpdateByUser(@RequestBody User user){
        return eightService.userUpdateByUser(user);
    }
}
