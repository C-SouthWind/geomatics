package com.eight.controller.home;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/25 15:47
 * @params :  MappingprojectController
 */
@RestController
@RequestMapping("/mappingproject")
@Api(value = "查询测绘项目",tags = "查询测绘项目接口")
public class MappingprojectController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping ("/selectMappingproject")
    @ApiOperation(value = "查询功能", notes = "用户查询测绘项目功能")
    public ResultData selectMappingproject(@RequestParam Map map){

        return eightService.selectMappingproject(map);
    }

}
