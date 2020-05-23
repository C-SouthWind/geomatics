package com.eight.service.manage;


import com.eight.base.ResultData;
import com.eight.mapper.manage.DictMapper;
import com.eight.model.manage.Dict;
import com.eight.redis.RedisService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 15:03
 * @params :
 */
@Service
public class DictService {
    @Autowired
    private DictMapper dictMapper;

    /** 方法描述
    * @Description: 系统管理--->字典管理
     *                      修改dict表单个数据
    * @Param: [dict]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/23
    */
    public Integer dictUpdateByDict( Dict dict){
        if (NotEmpty.objectNotEmpty(dict)) {
            int update = dictMapper.updateByPrimaryKey(dict);
            if (NotEmpty.objectNotEmpty(update)) {
                return update;
            }
        }
        return null;
    }


    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      查询dict表单个数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Dict dictSelectOneByDict(@RequestBody Dict dict){
        if (NotEmpty.objectNotEmpty(dict)) {
            Dict dict1 = dictMapper.selectOne(dict);
            if (NotEmpty.objectNotEmpty(dict1)) {
                return dict1;
            }
        }
        return null;
    }


    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      删除dict表数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Integer dictDeleteByDict(@RequestBody Dict dict){
        if (NotEmpty.objectNotEmpty(dict)) {
            int delete = dictMapper.delete(dict);
            if (NotEmpty.integerNotEmpty(delete)) {
                return delete;
            }
        }
        return null;
    }


    /** 方法描述
    * @Description: 系统管理--->字典管理
     *                      新增dict表数据
    * @Param: [dict]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/23
    */
    public Integer dictInsertByDict(Dict dict){
        if (NotEmpty.objectNotEmpty(dict)) {
            int insert = dictMapper.insert(dict);
            if (NotEmpty.integerNotEmpty(insert)) {
                return insert;
            }
        }
        return null;
    }

    /** 方法描述
    * @Description: 分页条件查询
     *                      系统管理--->字典管理       dict表
    * @Param: [map, redisService]
    * @return: java.util.List<com.eight.model.manage.Dict>
    * @Author: chj
    * @Date: 2020/5/23
    */
    public PageInfo<Dict> dictSelectPage(Map map , RedisService redisService){
        if (NotEmpty.mapNotEmpty(map)) {
            Object ky = map.get("keyy");
            Object ve = map.get("valuee");
            Object fn = map.get("fieldName");
            Object tn = map.get("tableName");
            Object pn = map.get("pageNo");
            Object ps = map.get("pageSize");
            Long keyy = NotEmpty.objectNotEmpty(ky) ? Long.parseLong(ky.toString()) : null;
            String valuee = NotEmpty.objectNotEmpty(ve) ? ve.toString() : null;
            String fieldName = NotEmpty.objectNotEmpty(fn) ? fn.toString() : null;
            String tableName = NotEmpty.objectNotEmpty(tn) ? tn.toString() : null;
            Integer pageNo = NotEmpty.objectNotEmpty(pn) ? Integer.parseInt(pn.toString()) : null;
            Integer pageSize = NotEmpty.objectNotEmpty(ps) ? Integer.parseInt(ps.toString()) : null;
            //是否传入当前页和每页个数
            if(NotEmpty.integerNotEmpty(pageNo) && NotEmpty.integerNotEmpty(pageSize)){
                if (pageNo > 0 && pageSize > 0) {
                    return selectPage(pageNo,pageSize,keyy, valuee, fieldName, tableName);
                }
            }
            //默认第一页 10个 无条件
            return selectPage(1,10,keyy, valuee, fieldName, tableName);
        }
        return selectPage(1,10,null, null, null, null);
    }

    /** 方法描述
     * @Description: 分页查询
     * @Param: [pageNo, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.eight.model.login.User>
     * @Author: chj
     * @Date: 2020/5/22
     */
    private PageInfo<Dict> selectPage(Integer paegNo,Integer pageSize,Long keyy,String valuee,String fieldName,String tableName){
        PageHelper.startPage(paegNo, pageSize);
        List<Dict> dicts = conditionsSelect(keyy, valuee, fieldName, tableName);
        PageInfo<Dict> dictPageInfo = new PageInfo<Dict>(dicts);
        return dictPageInfo;
    }

   /** 方法描述
   * @Description: 条件查询
    *                   是否根据键 值 表名  字段 查询
   * @Param: [keyy, valuee, fieldName, tableName]
   * @return: java.util.List<com.eight.model.manage.Dict>
   * @Author: chj
   * @Date: 2020/5/23
   */
    private List<Dict> conditionsSelect(Long keyy,String valuee,String fieldName,String tableName){
        List<Dict> dicts = null;
        Example example = new Example(Dict.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.longNotEmpty(keyy)) {
            criteria.andEqualTo("keyy",keyy);
        }
        if (NotEmpty.stringNotEmpty(valuee)) {
            criteria.andEqualTo("valuee",valuee);
        }
        if (NotEmpty.stringNotEmpty(fieldName)) {
            criteria.andEqualTo("fieldName",fieldName);
        }
        if (NotEmpty.stringNotEmpty(tableName)) {
            criteria.andEqualTo("tableName",tableName);
        }
        try {
            dicts = dictMapper.selectByExample(example);
        }catch (Exception e){
            return null;
        }
        return dicts;
    }

}
