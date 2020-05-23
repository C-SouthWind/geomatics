package com.eight.controller.manage;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.manage.Dept;
import com.eight.redis.RedisService;
import com.eight.service.manage.DeptService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 18:42
 * @params :        系统管理  部门管理
 */
@RestController
@RequestMapping("/dept")
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private RedisService redisService;

    /** 方法描述
     * @Description: 分页条件查询
     *                  系统管理--->字典管理       dept表
     * @Param: [map]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/deptSelectPage")
    public ResultData deptSelectPage(@RequestParam Map map){
        PageInfo<Dept> deptPageInfo = deptService.deptSelectPage(map,redisService);
        return null != deptPageInfo ? selectSuccess(deptPageInfo) : selectFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      新增dept表
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/deptInsertByDept")
    public ResultData deptInsertBydept(@RequestBody Dept dept){
        Integer integer = deptService.deptInsertByDept(dept);
        return NotEmpty.integerNotEmpty(integer) ? insertSuccess("新增"+integer+"条数据") : insertFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      删除dept表数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/deptDeleteByDept")
    public ResultData deptDeleteBydept(@RequestBody Dept dept){
        Integer integer = deptService.deptDeleteByDept(dept);
        return NotEmpty.integerNotEmpty(integer) ? deleteSuccess("删除"+integer+"条数据") : deleteFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      查询dept表单个数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/deptSelectOneByDept")
    public ResultData deptSelectOneBydept(@RequestBody Dept dept){
        Dept dept1 = deptService.deptSelectOneByDept(dept);
        return NotEmpty.objectNotEmpty(dept1) ? selectSuccess(dept) : selectFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      修改dept表单个数据
     * @Param: [dept]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/deptUpdateByDept")
    public ResultData deptUpdateBydept(@RequestBody Dept dept){
        Integer integer = deptService.deptUpdateByDept(dept);
        return NotEmpty.integerNotEmpty(integer) ? updateSuccess("修改"+integer+"条数据") : updateFailed();

    }


}
