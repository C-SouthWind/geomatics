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
 * @date ：Created in 2020/5/23 15:45
 * @params :  MappingunitController
 */

@RestController
@RequestMapping("/mappingunit")
@Api(value = "查询测绘单位",tags = "查询测绘单位接口")
public class MappingunitController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping("/selectMappingunit")
    @ApiOperation(value = "查询功能", notes = "用户查询测绘单位功能")
    public ResultData selectMappingunit(@RequestParam Map map) {
        System.out.println(map);
        return eightService.selectMappingunit(map);
    }
}
