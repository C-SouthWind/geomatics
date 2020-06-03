package com.eight.controller.manage;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.manage.Role;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "系统管理 -->角色管理" ,tags = "角色管理接口")
public class RoleController extends BaseController {
    @Autowired
    private EightService eightService;

    /** 方法描述
    * @Description: 分页条件查询
     *                      系统管理--->角色管理       role表
    * @Param: [map, redisService]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/23
    */
    @PostMapping("/roleSelect")
    @ApiOperation(value = "系统管理 -->角色管理",notes = "根据role表  查询所有数据")
        public ResultData roleSelect(@RequestParam Map map){
       return eightService.roleSelect(map);
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
    @ApiOperation(value = "系统管理 -->角色管理",notes = "根据role表  删除role表数据")
    public ResultData roleDeleteByRole(@RequestBody Role role){
        return eightService.roleDeleteByRole(role);
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
    @ApiOperation(value = "系统管理 -->角色管理",notes = "根据role表  查询单个信息")
    public ResultData roleSelectOneByRole(@RequestBody Role role){
        return eightService.roleDeleteByRole(role);
    }
}
