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
 * @date ：Created in 2020/5/26 15:45
 * @params :  ResultcommitController
 */
@RestController
@RequestMapping("/resultcommit")
@Api(value = "查询测绘成果",tags = "查询测绘成果接口")
public class ResultcommitController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping("/selectResultcommit")
    @ApiOperation(value = "查询功能", notes = "用户查询测绘成果功能")
    public ResultData selectResultcommit(@RequestParam Map map) {
       return eightService.selectResultcommit(map);

    }
}
