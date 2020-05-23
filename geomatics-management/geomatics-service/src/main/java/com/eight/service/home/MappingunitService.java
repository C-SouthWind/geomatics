package com.eight.service.home;

import com.eight.mapper.home.MappingunitMapper;
import com.eight.model.home.Mappingunit;
import com.eight.model.login.User;
import com.eight.redis.RedisService;
import com.eight.utils.JSONUtil;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

import static com.eight.staticstatus.RedisProperties.EX;
import static com.eight.staticstatus.RedisProperties.NX;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/22 15:51
 * @params :  MappingunitService
 */
@Service
public class MappingunitService {
    @Autowired
    public MappingunitMapper mappingunitMapper;

    /** 
    * @Description:
    * @Param:  测绘单位查询
    * @return:  
    * @Author: hxy 
    * @Date: 2020/5/22 
    */

    public List<Mappingunit> selectMappingunit(Map map, RedisService redisService){

        String unitName = null;
        String ownedDistrict = null;
        String qualificationLevel = null;


        if (NotEmpty.mapNotEmpty(map)) {
            Object nu = map.get("unitName");
            Object od = map.get("ownedDistrict");
            Object ql = map.get("qualificationLevel");
            unitName = NotEmpty.objectNotEmpty(nu) ? nu.toString(): null;
            ownedDistrict = NotEmpty.objectNotEmpty(od) ? od.toString(): null;
            qualificationLevel = NotEmpty.objectNotEmpty(ql) ? ql.toString(): null;

        }
            return conditionsSelect(unitName,ownedDistrict,qualificationLevel);
    }


//    /**
//    * @Description:
//    * @Param:  判断是否存入redis
//    * @return:
//    * @Author: hxy
//    * @Date: 2020/5/22
//    */
//    public boolean redisOperate (List<Mappingunit> mappingunit, RedisService redisService){
//        if (mappingunit.size()>0   &&   mappingunit!=null ) {
//            try {
//                redisService.set("mappingunitselecthxy", JSONUtil.toJsonString(mappingunit),NX,EX,1800);
//
//            }catch(JedisNoReachableClusterNodeException e){
//                System.out.println("mappingunitselecthxy失败");
//                return false;
//            }
//        }
//        return true;
//    }

    /**
    * @Description:
    * @Param:  根据单位名称、地区、资质条件查询
    * @return:
    * @Author: hxy
    * @Date: 2020/5/22
    */
    private  List<Mappingunit> conditionsSelect(String unitName,String ownedDistrict,String qualificationLevel) {
        List<Mappingunit> mappingunit = null;
        Example example = new Example(Mappingunit.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.stringNotEmpty(unitName)) {
            criteria.andEqualTo("unitName", unitName);
        }
        if (NotEmpty.stringNotEmpty(ownedDistrict)) {
            criteria.andEqualTo("ownedDistrict", ownedDistrict);
        }
        if (NotEmpty.stringNotEmpty(qualificationLevel)) {
            criteria.andEqualTo("qualificationLevel", qualificationLevel);
        }
        try {
            mappingunit = mappingunitMapper.selectByExample(example);
        } catch (Exception e) {
            return null;
        }
        return mappingunit;
    }
}
