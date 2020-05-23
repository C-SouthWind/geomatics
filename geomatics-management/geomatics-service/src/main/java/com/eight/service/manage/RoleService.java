package com.eight.service.manage;

import com.eight.mapper.login.UserMapper;
import com.eight.mapper.manage.RoleMapper;
import com.eight.model.login.User;
import com.eight.model.manage.Dict;
import com.eight.model.manage.Role;
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
 * @date ：Created in 2020/5/23 19:17
 * @params :
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      根据role表  查询单个信息
     * @Param: [role]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    public Role roleSelectOneByRole(Role role){
        if (NotEmpty.objectNotEmpty(role)) {
            Role role1 = roleMapper.selectOne(role);
            if (NotEmpty.objectNotEmpty(role1)) {
                return role1;
            }
        }
        return null;
    }




    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      删除role表数据
     * @Param: [role]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Integer roleDeleteByRole(@RequestBody Role role){
        if (NotEmpty.objectNotEmpty(role)) {
            int delete = roleMapper.delete(role);
            if (NotEmpty.integerNotEmpty(delete)) {
                return delete;
            }
        }
        return null;
    }


    /** 方法描述
     * @Description: 分页条件查询
     *                   系统管理--->角色管理       role表
     * @Param: [map, redisService]
     * @return: com.github.pagehelper.PageInfo<com.eight.model.manage.Role>
     * @Author: chj
     * @Date: 2020/5/22
     */
    public PageInfo<Role> roleSelectPage(Map map, RedisService redisService){
        //非空判断
        if (NotEmpty.mapNotEmpty(map)) {
            //拿到map中的值
            Object rn = map.get("roleName");
            Object pn = map.get("pageNo");
            Object ps = map.get("pageSize");
            String roleName = NotEmpty.objectNotEmpty(rn) ? rn.toString() : null;
            Integer pageNo = NotEmpty.objectNotEmpty(pn) ? Integer.parseInt(pn.toString()) : null;
            Integer pageSize = NotEmpty.objectNotEmpty(ps) ? Integer.parseInt(ps.toString()) : null;
            if (NotEmpty.integerNotEmpty(pageNo) && NotEmpty.integerNotEmpty(pageSize)) {
                //判断是否分页
                if (pageNo > 0 && pageSize > 0) {
                    return selectPage(pageNo, pageSize,roleName);
                }
            }
            //默认第一页  每页十条 无条件
            return selectPage(1,10,roleName);
        }
        //默认第一页  每页十条 无条件
        return selectPage(1,10,null);
    }



    /** 方法描述
     * @Description: 分页查询
     * @Param: [pageNo, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.eight.model.manage.Role>
     * @Author: chj
     * @Date: 2020/5/22
     */
    private PageInfo<Role> selectPage(Integer pageNo, Integer pageSize,String roleName){
        PageHelper.startPage(pageNo,pageSize);
        List<Role> roles = conditionsSelect(roleName);
        PageInfo<Role> rolePageInfo = new PageInfo<Role>(roles);
        return rolePageInfo;
    }

    /** 方法描述
     * @Description: 条件查询
     *                  是否根据  角色 查询
     * @Param: [roleName]
     * @return: java.util.List<com.eight.model.manage.Role>
     * @Author: chj
     * @Date: 2020/5/22
     */
    private List<Role> conditionsSelect(String roleName) {
        List<Role> roles =null;
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.stringNotEmpty(roleName)) {
            criteria.andEqualTo("roleName",roleName);
        }
        try {
            roles = roleMapper.selectByExample(example);
        }catch (Exception e){
            return null;
        }
        return roles;
    }

}
