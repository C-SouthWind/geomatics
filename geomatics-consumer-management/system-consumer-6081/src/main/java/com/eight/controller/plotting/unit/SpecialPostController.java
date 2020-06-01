package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Equipment;
import com.eight.model.plotting.unit.SpecialPost;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/30 20:42
 * @params :  SpecialPostController
 */
@RestController
@Api(value = "查询特殊岗位信息",tags = "查询特殊岗位信息接口")
public class SpecialPostController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping("/selectSpecialPost")
    @ApiOperation(value = "查询功能", notes = "查询特殊岗位信息功能")
    public ResultData selectSpecialPost(SpecialPost specialpost) {
        return eightService.selectSpecialPost(specialpost);
    }
}
