package com.eight.service.home;

import com.eight.mapper.home.MappingprojectMapper;
import com.eight.model.home.Mappingproject;
import com.eight.model.home.Mappingunit;
import com.eight.redis.RedisService;
import com.eight.utils.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/25 14:18
 * @params :  MappingprojectService
 */
@Service
public class MappingprojectService {
    @Autowired
    public MappingprojectMapper mappingprojectMapper;

    /** 
    * @Description: 查询 测绘项目
    * @Param:  
    * @return:  
    * @Author: hxy 
    * @Date: 2020/5/25 
    */
    public List<Mappingproject> selectMappingproject(Map map, RedisService redisService){

        String projectName = null;
        String projectType = null;
        String startDate = null;


        if (NotEmpty.mapNotEmpty(map)) {
            Object pn = map.get("projectName");
            Object pt = map.get("projectType");
            Object sd = map.get("startDate");
            projectName = NotEmpty.objectNotEmpty(pn) ? pn.toString(): null;
            projectType = NotEmpty.objectNotEmpty(pt) ? pt.toString(): null;
            startDate = NotEmpty.objectNotEmpty(sd) ? sd.toString(): null;

        }
        return conditionsSelect(projectName,projectType,startDate);
    }

    /**
    * @Description: 根据条件查询
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/25
    */
    private  List<Mappingproject> conditionsSelect(String projectName,String projectType,String startDate) {
        List<Mappingproject> mappingproject = null;
        Example example = new Example(Mappingproject.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.stringNotEmpty(projectName)) {
            criteria.andEqualTo("projectName", projectName);
        }
        if (NotEmpty.stringNotEmpty(projectType)) {
            criteria.andEqualTo("projectType", projectType);
        }
        if (NotEmpty.stringNotEmpty(startDate)) {
            criteria.andEqualTo("startDate", startDate);
        }
        try {
            mappingproject = mappingprojectMapper.selectByExample(example);
        } catch (Exception e) {
            return null;
        }
        return mappingproject;
    }
}
