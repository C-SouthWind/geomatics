package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Principal;
import com.eight.model.plotting.unit.Technicist;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 21:29
 * @params :  TechnicistController
 */
@RestController
@Api(value = "查询技术人员信息",tags = "查询技术人员信息接口")
public class TechnicistController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping("/selectTechnicist")
    @ApiOperation(value = "查询功能", notes = "法人信息功能")
    public ResultData selectTechnicist(Technicist technicist) {
        return eightService.selectTechnicist(technicist);
    }
}
