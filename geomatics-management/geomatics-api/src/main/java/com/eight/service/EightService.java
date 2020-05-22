package com.eight.service;

import com.eight.base.ResultData;
import com.eight.model.login.User;
import com.eight.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 20:32
 * @params :
 */
@FeignClient(value = "system-interface")
public interface EightService {

    /** 方法描述
     * @Description: 执行登录操作
     * @Param: [user]
     * @return: com.chj.vo.TokenVo
     * @Author: chj
     * @Date: 2020/5/15
     */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /** 方法描述 
    * @Description:系统管理 -->用户管理  条件分页查询
    * @Param: [map]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/userSelectPage")
    ResultData userSelectPage(@RequestParam Map map);

    /** 方法描述
    * @Description: 系统管理--->用户管理
     *                  根据user表对象删除用户
    * @Param: [user]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/userDeleteByuser")
    ResultData userDeleteByuser(@RequestBody User user);


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                      根据user表对象新增用户
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userInsertByUser")
    ResultData userInsertByUser(@RequestBody User user);


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                      根据user表  查询单个信息
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userSelectOneByUser")
    ResultData userSelectOneByUser(@RequestBody User user);


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                  根据user表  修改信息
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/userUpdateByUser")
    ResultData userUpdateByUser(@RequestBody User user);


    /** 方法描述
    * @Description: 系统管理--->用户管理
     *                      根据user表 密码重置
    * @Param: [user]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/userResetPassword")
    public ResultData userResetPassword(@RequestBody User user);
}
