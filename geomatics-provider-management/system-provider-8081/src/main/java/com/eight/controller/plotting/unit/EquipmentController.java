package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Equipment;
import com.eight.model.plotting.unit.Principal;
import com.eight.redis.RedisService;
import com.eight.service.plotting.unit.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 21:39
 * @params :  EquipmentController
 */
@RequestMapping("/plotting")
@RestController
public class EquipmentController extends BaseController {
    @Autowired
    public EquipmentService equipmentService;

    @Autowired
    private RedisService redisService;
    
    /** 
    * @Description: 查询仪器设备
    * @Param:  
    * @return:  
    * @Author: hxy 
    * @Date: 2020/5/29 
    */
    @PostMapping("/unit/selectEquipment")
    public ResultData selectEquipment(){
        List<Equipment> equipment = equipmentService.selectEquipment(redisService);
        if (null == equipment) {
            return selectFailed();
        }
        return selectSuccess(equipment);
    }
}
