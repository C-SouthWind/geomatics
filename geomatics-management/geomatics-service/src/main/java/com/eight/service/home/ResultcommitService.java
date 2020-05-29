package com.eight.service.home;

import com.eight.mapper.home.MappingprojectMapper;
import com.eight.mapper.home.ResultcommitMapper;
import com.eight.model.home.Mappingproject;
import com.eight.model.home.Resultcommit;
import com.eight.redis.RedisService;
import com.eight.utils.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/26 15:32
 * @params :  ResultcommitService
 */
@Service
public class ResultcommitService {
    @Autowired
    public ResultcommitMapper resultcommitMapper;


    /**
    * @Description: 查询测绘成果
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/26
    */
    public List<Resultcommit> selectResultcommit(Map map, RedisService redisService){

        String name = null;
        String resultDate = null;
        String projectType = null;


        if (NotEmpty.mapNotEmpty(map)) {
            Object na = map.get("name");
            Object rd = map.get("resultDate");
            Object pt = map.get("projectType");
            name = NotEmpty.objectNotEmpty(na) ? na.toString(): null;
            resultDate = NotEmpty.objectNotEmpty(rd) ? rd.toString(): null;
            projectType = NotEmpty.objectNotEmpty(pt) ? pt.toString(): null;

        }
        return conditionsSelect(name,resultDate,projectType);
    }

    /**
    * @Description: 根据条件查询
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/26
    */
    private  List<Resultcommit> conditionsSelect(String name,String resultDate,String projectType) {
        List<Resultcommit> resultcommit = null;
        Example example = new Example(Resultcommit.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.stringNotEmpty(name)) {
            criteria.andEqualTo("name", name);
        }
        if (NotEmpty.stringNotEmpty(resultDate)) {
            criteria.andEqualTo("resultDate", resultDate);
        }
        if (NotEmpty.stringNotEmpty(projectType)) {
            criteria.andEqualTo("projectType", projectType);
        }
        try {
            resultcommit = resultcommitMapper.selectResultcommit();
        } catch (Exception e) {
            return null;
        }
        return resultcommit;
    }
}
