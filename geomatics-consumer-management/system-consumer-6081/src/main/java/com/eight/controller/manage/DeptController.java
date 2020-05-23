package com.eight.controller.manage;

import com.eight.base.ResultData;
import com.eight.model.manage.Dept;
import com.eight.model.manage.Dict;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 19:02
 * @params :
 */
@RestController
@RequestMapping("/dept")
@Api(value = "系统管理 -->部门管理" ,tags = "部门管理接口")
public class DeptController {
    @Autowired
    private EightService eightService;

    /** 方法描述
     * @Description: 分页条件查询
     *                  系统管理--->部门管理       dept表
     * @Param: [map]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptSelectPage")
    @ApiOperation(value = "系统管理 -->部门管理",notes = "根据dept表  修改dept表单个数据")
    public ResultData deptSelectPage(@RequestParam Map map){
        return eightService.deptSelectPage(map);
    }

    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      新增dept表
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptInsertByDept")
    @ApiOperation(value = "系统管理 -->部门管理",notes = "根据dept表  新增dept表")
    public ResultData deptInsertByDept(@RequestBody Dept dept){
        return eightService.deptInsertByDept(dept);
    }


    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      删除dept表数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptDeleteByDept")
    @ApiOperation(value = "系统管理 -->部门管理",notes = "根据dept表  删除dept表数据")
    public ResultData deptDeleteByDept(@RequestBody Dept dept){
        return eightService.deptDeleteByDept(dept);
    }

    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      查询dept表单个数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptSelectOneByDept")
    @ApiOperation(value = "系统管理 -->部门管理",notes = "根据dept表  查询dept表单个数据")
    public ResultData deptSelectOneByDept(@RequestBody Dept dept){
        return eightService.deptSelectOneByDept(dept);
    }

    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      修改dept表单个数据
     * @Param: [dept]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptUpdateByDept")
    @ApiOperation(value = "系统管理 -->部门管理",notes = "根据dept表  修改dept表单个数据")
    public  ResultData deptUpdateByDept(@RequestBody Dept dept){
        return eightService.deptUpdateByDept(dept);
    }
}
