package com.eight.service.plotting.unit;

import com.eight.base.BaseService;
import com.eight.mapper.home.MappingprojectMapper;
import com.eight.mapper.home.MappingunitMapper;
import com.eight.mapper.plotting.unit.UnitMapper;
import com.eight.model.home.Mappingunit;
import com.eight.model.login.User;
import com.eight.model.plotting.unit.Unit;
import com.eight.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/28 20:34
 * @params :  UnitService
 */
@Service
public class UnitService  {
    @Autowired
    private UnitMapper unitMapper;


    /**
    * @Description: 查询全部基本信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    public List<Unit> selectUnit(RedisService redisService){
        List<Unit> unit = unitMapper.selectAll();
        if (null!=unit && unit.size()>0) {
                return unit;
        }
        return null;
    }


}
