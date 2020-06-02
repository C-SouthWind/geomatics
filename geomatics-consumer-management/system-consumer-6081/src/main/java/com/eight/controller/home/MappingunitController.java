package com.eight.controller.home;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.home.Mappingunit;
import com.eight.model.login.User;
import com.eight.service.EightService;
import com.eight.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/23 15:45
 * @params :  MappingunitController
 */

@RestController
@Api(value = "查询测绘单位",tags = "查询测绘单位接口")
public class MappingunitController extends BaseController {
    @Autowired
    private EightService eightService;

    @GetMapping("/selectMappingunit")
    @ApiOperation(value = "查询功能", notes = "用户查询测绘单位功能")
    public ResultData selectMappingunit(Mappingunit mappingunit) {
       // TokenVo tokenVo = eightService.selectMappingunit(mappingunit);
       // return tokenVo.getIfSuccess()?super.selectSuccess(tokenVo.getToken()):super.selectFailed();
        return null;
    }
}
