package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Principal;
import com.eight.model.plotting.unit.Unit;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 20:43
 * @params :  PrincipalController
 */
@RestController
@Api(value = "查询法人信息",tags = "查询法人信息接口")
public class PrincipalController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping("/selectPrincipal")
    @ApiOperation(value = "查询功能", notes = "法人信息功能")
    public ResultData selectPrincipal(Principal principal) {
        return eightService.selectPrincipal(principal);
    }
}
