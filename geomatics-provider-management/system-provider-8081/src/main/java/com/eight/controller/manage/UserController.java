package com.eight.controller.manage;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.login.User;
import com.eight.redis.RedisService;
import com.eight.service.manage.UserService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/22 15:09
 * @params :      系统管理   用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /** 方法描述
    * @Description:  系统管理 -->用户管理  条件分页查询
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

    /** 方法描述
    * @Description: 系统管理--->用户管理
     *                      根据user表对象删除用户
    * @Param: [user]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/userDeleteByuser")
    public ResultData userDeleteByuser(@RequestBody User user){
        Integer integer = userService.userDeleteByuser(user);
       return NotEmpty.integerNotEmpty(integer) ? deleteSuccess() : deleteFailed();
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
    public ResultData userInsertByUser(@RequestBody User user){
        Integer integer = userService.userInsertByUser(user);
        return NotEmpty.integerNotEmpty(integer) ? insertSuccess() : insertFailed();
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
    public ResultData userSelectOneByUser(@RequestBody User user){
        User user1 = userService.userSelectOneByUser(user);
        return NotEmpty.objectNotEmpty(user1) ? selectSuccess(user1) : selectFailed();
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
    public ResultData userUpdateByUser(@RequestBody User user){
        Integer integer = userService.userUpdateByUser(user);
        return NotEmpty.integerNotEmpty(integer) ? updateSuccess() : updateFailed();
    }

    /** 方法描述
    * @Description: 系统管理--->用户管理
     *                      根据user表  密码重置
    * @Param: [user]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/userResetPassword")
    public ResultData userResetPassword(@RequestBody User user){
        Integer integer = userService.userResetPassword(user);
        return NotEmpty.integerNotEmpty(integer) ? updateSuccess("密码为123456") : updateFailed();
    }


}
