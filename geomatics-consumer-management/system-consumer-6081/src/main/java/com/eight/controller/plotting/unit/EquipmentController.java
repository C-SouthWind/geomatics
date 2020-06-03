package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Equipment;
import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 21:51
 * @params :  EquipmentController
 */
@RestController
@Api(value = "查询仪器设备信息",tags = "查询仪器设备信息接口")
public class EquipmentController extends BaseController {
    @Autowired
    private EightService eightService;

    @PostMapping("/selectEquipment")
    @ApiOperation(value = "查询功能", notes = "查询仪器设备信息功能")
    public ResultData selectEquipment(Equipment equipment) {
        return eightService.selectEquipment(equipment);
    }
}
