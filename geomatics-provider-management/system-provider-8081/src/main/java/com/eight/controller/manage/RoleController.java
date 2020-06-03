package com.eight.controller.manage;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.manage.Role;
import com.eight.redis.RedisService;
import com.eight.service.manage.RoleService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 19:17
 * @params :  系统管理  角色管理
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RedisService redisService;

    /** 方法描述
    * @Description: 分页条件查询
     *                      系统管理--->角色管理       role表
    * @Param: [map, redisService]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/23
    */
    @PostMapping("/roleSelectPage")
    public ResultData roleSelectPage(@RequestParam Map map){
        PageInfo<Role> rolePageInfo = roleService.roleSelectPage(map, redisService);
        return null != rolePageInfo ? selectSuccess(rolePageInfo) : selectFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      删除role表数据
     * @Param: [role]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/roleDeleteByRole")
    public ResultData roleDeleteByRole(@RequestBody Role role){
        Integer integer = roleService.roleDeleteByRole(role);
        return NotEmpty.integerNotEmpty(integer) ? deleteSuccess("删除"+integer+"条数据") : deleteFailed();
    }


    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      根据role表  查询单个信息
     * @Param: [role]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/roleSelectOneByRole")
    public ResultData roleSelectOneByRole(@RequestBody Role role){
        Role role1 = roleService.roleSelectOneByRole(role);
        return NotEmpty.objectNotEmpty(role1) ? selectSuccess(role1) : selectFailed();
    }
}
