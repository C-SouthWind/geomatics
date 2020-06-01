package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.BaseService;
import com.eight.base.ResultData;
import com.eight.model.home.Mappingunit;
import com.eight.model.plotting.unit.Unit;
import com.eight.redis.RedisService;
import com.eight.service.home.MappingunitService;
import com.eight.service.plotting.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/28 22:03
 * @params :  UnitController
 */
@RequestMapping("/plotting/unit")
@RestController
public class UnitController extends BaseController {
    @Autowired
    public UnitService unitService;

    @Autowired
    private RedisService redisService;

    /**
    * @Description: 查询单位基本信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/28
    */
    @PostMapping("/selectUnit")
    public ResultData selectUnit(){
        List<Unit> unit = unitService.selectUnit(redisService);
        if (null == unit) {
            return selectFailed();
        }
        return selectSuccess(unit);
    }
}
