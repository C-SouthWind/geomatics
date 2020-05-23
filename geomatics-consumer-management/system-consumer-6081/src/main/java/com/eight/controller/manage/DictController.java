package com.eight.controller.manage;

import com.eight.base.ResultData;
import com.eight.model.manage.Dict;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 15:39
 * @params :
 */
@RestController
@RequestMapping("/dict")
@Api(value = "系统管理 -->用户管理" ,tags = "字典管理接口")
public class DictController {
    @Autowired
    private EightService eightService;

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      修改dict表单个数据
     * @Param: [dict]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictUpdateByDict")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据dict表  修改dict表单个数据")
    public ResultData dictUpdateByDict(@RequestBody Dict dict){
        return eightService.dictUpdateByDict(dict);
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      查询dict表单个数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictSelectOneByDict")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据dict表  查询dict表单个数据")
    public ResultData dictSelectOneByDict(@RequestBody Dict dict){
        return eightService.dictSelectOneByDict(dict);
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      删除dict表数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictDeleteByDict")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据dict表  删除字典管理字段")
    public ResultData dictDeleteByDict(@RequestBody Dict dict){
        return eightService.dictDeleteByDict(dict);
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      新增dict表
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictInsertByDict")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据dict表  新增字典管理")
    public ResultData dictInsertByDict(@RequestBody Dict dict){
        return eightService.dictInsertByDict(dict);
    }

    /** 方法描述
     * @Description: 分页条件查询
     *                  系统管理--->字典管理       dict表
     * @Param: [map]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictSelectPage")
    @ApiOperation(value = "系统管理 -->用户管理",notes = "根据dict表 条件分页查询")
    public ResultData dictSelectPage(@RequestParam Map map){
        return eightService.dictSelectPage(map);
    }
}
