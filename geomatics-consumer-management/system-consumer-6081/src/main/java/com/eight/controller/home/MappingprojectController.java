package com.eight.controller.home;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.home.Mappingproject;
import com.eight.model.home.Mappingunit;
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
 * @date ：Created in 2020/5/25 15:47
 * @params :  MappingprojectController
 */
@RestController
@Api(value = "查询测绘项目",tags = "查询测绘项目接口")
public class MappingprojectController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping ("/selectMappingproject")
    @ApiOperation(value = "查询功能", notes = "用户查询测绘项目功能")
    public ResultData selectMappingproject(Mappingproject mappingproject) {
        return eightService.selectMappingproject(mappingproject);

    }

}
