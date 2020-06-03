package com.eight.controller.manage;


import com.eight.base.ResultData;
import com.eight.model.manage.Menu;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 19:52
 * @params :
 */
@RestController
@RequestMapping("/menu")
@Api(value = "系统管理 -->菜单管理" ,tags = "菜单管理接口")
public class MenuController{

    @Autowired
    private EightService eightService;

    /** 方法描述
     * @Description: 分页条件查询
     *                      系统管理--->菜单管理       menu表
     * @Param: [map, redisService]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/menuSelect")
    @ApiOperation(value = "系统管理 -->菜单管理",notes = "根据menu表  查询所有数据")
    public ResultData menuSelect(@RequestParam Map map){
       return eightService.menuSelect(map);
    }

    /** 方法描述
     * @Description: 系统管理--->菜单管理
     *                      删除menu表数据
     * @Param: [role]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/menuDeleteByMenu")
    @ApiOperation(value = "系统管理 -->菜单管理",notes = "根据menu表  删除menu表数据")
    public ResultData menuDeleteByMenu(@RequestBody Menu menu){
       return eightService.menuDeleteByMenu(menu);
    }


    /** 方法描述
     * @Description: 系统管理--->菜单管理
     *                      根据menu表  查询单个信息
     * @Param: [menu]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/menuSelectOneByMenu")
    @ApiOperation(value = "系统管理 -->菜单管理",notes = "根据menu表  查询单个信息")
    public ResultData menuSelectOneByMenu(@RequestBody Menu menu){
        return eightService.menuSelectOneByMenu(menu);
    }
}
