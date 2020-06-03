package com.eight.service.plotting.unit;

import com.eight.mapper.plotting.unit.TechnicistMapper;
import com.eight.model.plotting.unit.Principal;
import com.eight.model.plotting.unit.Technicist;
import com.eight.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 20:50
 * @params :  TechnicistService
 */
@Service
public class TechnicistService {
    @Autowired
    private TechnicistMapper technicistMapper;

    /**
    * @Description: 查询 技术人员
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    public List<Technicist> selectTechnicist(RedisService redisService){
        List<Technicist> technicist = technicistMapper.selectAll();
        if (null!=technicist && technicist.size()>0) {
            return technicist;
        }
        return null;
    }
}
