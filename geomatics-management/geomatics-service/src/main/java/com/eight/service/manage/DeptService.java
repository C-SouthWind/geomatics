package com.eight.service.manage;

import com.eight.mapper.manage.DeptMapper;
import com.eight.model.manage.Dept;
import com.eight.redis.RedisService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 18:45
 * @params :
 */
@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      修改dept表单个数据
     * @Param: [dept]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Integer deptUpdateByDept( Dept dept){
        if (NotEmpty.objectNotEmpty(dept)) {
            int update = deptMapper.updateByPrimaryKey(dept);
            if (NotEmpty.objectNotEmpty(update)) {
                return update;
            }
        }
        return null;
    }


    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      查询dept表单个数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Dept deptSelectOneByDept( Dept dept){
        if (NotEmpty.objectNotEmpty(dept)) {
            Dept dept1 = deptMapper.selectOne(dept);
            if (NotEmpty.objectNotEmpty(dept1)) {
                return dept1;
            }
        }
        return null;
    }


    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      删除dept表数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Integer deptDeleteByDept( Dept dept){
        if (NotEmpty.objectNotEmpty(dept)) {
            int delete = deptMapper.delete(dept);
            if (NotEmpty.integerNotEmpty(delete)) {
                return delete;
            }
        }
        return null;
    }


    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      新增dept表数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Integer deptInsertByDept(Dept dept){
        if (NotEmpty.objectNotEmpty(dept)) {
            int insert = deptMapper.insert(dept);
            if (NotEmpty.integerNotEmpty(insert)) {
                return insert;
            }
        }
        return null;
    }

    /** 方法描述
     * @Description: 分页条件查询
     *                      系统管理--->字典管理       dept表
     * @Param: [map, redisService]
     * @return: java.util.List<com.eight.model.manage.Dept>
     * @Author: chj
     * @Date: 2020/5/23
     */
    public PageInfo<Dept> deptSelectPage(Map map , RedisService redisService){
        if (NotEmpty.mapNotEmpty(map)) {
            Object dn = map.get("deptName");
            Object pn = map.get("pageNo");
            Object ps = map.get("pageSize");
            String deptName = NotEmpty.objectNotEmpty(dn) ? dn.toString() : null;
            Integer pageNo = NotEmpty.objectNotEmpty(pn) ? Integer.parseInt(pn.toString()) : null;
            Integer pageSize = NotEmpty.objectNotEmpty(ps) ? Integer.parseInt(ps.toString()) : null;
            //是否传入当前页和每页个数
            if(NotEmpty.integerNotEmpty(pageNo) && NotEmpty.integerNotEmpty(pageSize)){
                if (pageNo > 0 && pageSize > 0) {
                    return selectPage(pageNo,pageSize,deptName);
                }
            }
            //默认第一页 10个 无条件
            return selectPage(1,10,deptName);
        }
        return selectPage(1,10,null);
    }

    /** 方法描述
     * @Description: 分页查询
     * @Param: [pageNo, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.eight.model.login.User>
     * @Author: chj
     * @Date: 2020/5/22
     */
    private PageInfo<Dept> selectPage(Integer paegNo,Integer pageSize,String deptName){
        PageHelper.startPage(paegNo, pageSize);
        List<Dept> depts = conditionsSelect(deptName);
        PageInfo<Dept> deptPageInfo = new PageInfo<Dept>(depts);
        return deptPageInfo;
    }

    /** 方法描述
     * @Description: 条件查询
     *                   是否根据名称 查询
     * @Param: [keyy, valuee, fieldName, tableName]
     * @return: java.util.List<com.eight.model.manage.Dept>
     * @Author: chj
     * @Date: 2020/5/23
     */
    private List<Dept> conditionsSelect(String deptName){
        List<Dept> depts = null;
        Example example = new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.stringNotEmpty(deptName)) {
            criteria.andEqualTo("deptName",deptName);
        }
        try {
            depts = deptMapper.selectByExample(example);
        }catch (Exception e){
            return null;
        }
        return depts;
    }


}
