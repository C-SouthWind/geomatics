package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.home.Resultcommit;
import com.eight.model.plotting.unit.Unit;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 10:17
 * @params :  UnitController
 */
@RestController
@Api(value = "查询单位基本信息",tags = "查询单位基本信息接口")
public class UnitController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping("/selectUnit")
    @ApiOperation(value = "查询功能", notes = "用户单位基本信息功能")
    public ResultData selectUnit(Unit unit) {
        return eightService.selectUnit(unit);
    }
}