package com.eight.service.plotting.unit;

import com.eight.mapper.plotting.unit.EquipmentMapper;
import com.eight.model.plotting.unit.Equipment;
import com.eight.model.plotting.unit.Principal;
import com.eight.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 21:39
 * @params :  EquipmentService
 */
@Service
public class EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;
    
    /** 
    * @Description: 查询仪器设备
    * @Param:  
    * @return:  
    * @Author: hxy 
    * @Date: 2020/5/29 
    */
    public List<Equipment> selectEquipment(RedisService redisService){
        List<Equipment> equipment = equipmentMapper.selectAll();
        if (null!=equipment && equipment.size()>0) {
            return equipment;
        }
        return null;
    }
}
