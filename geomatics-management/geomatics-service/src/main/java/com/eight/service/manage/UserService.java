package com.eight.service.manage;

import com.eight.mapper.login.UserMapper;
import com.eight.model.login.User;
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
 * @date ：Created in 2020/5/22 15:12
 * @params :
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

   /** 方法描述
   * @Description: 分页条件查询
    *                   系统管理--->用户管理       user
   * @Param: [map, redisService]
   * @return: com.github.pagehelper.PageInfo<com.eight.model.login.User>
   * @Author: chj
   * @Date: 2020/5/22
   */
    public PageInfo<User>  userSelectPage(Map map, RedisService redisService){
        String   username = null;
        Integer  deptId = null;
        //非空判断
        if (NotEmpty.mapNotEmpty(map)) {
                //拿到map中的值
            Integer  pageNo =  Integer.parseInt(map.get("pageNo").toString());
            Integer  pageSize = Integer.parseInt(map.get("pageSize").toString());
             username = map.get("username").toString();
             deptId = Integer.parseInt(map.get("deptId").toString());
            if (NotEmpty.integerNotEmpty(pageNo) && NotEmpty.integerNotEmpty(pageSize)) {
                //判断是否分页
                if (pageNo > 0 && pageSize > 0) {
                    return selectPage(pageNo, pageSize,username,deptId);
                }
                //默认第一页  每页十条 无条件
               return selectPage(1,10,username,deptId);
            }
        }
        //默认第一页  每页十条 无条件
        return selectPage(1,10,username,deptId);
    }


    
     /** 方法描述 
     * @Description: 分页查询
     * @Param: [pageNo, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.eight.model.login.User>
     * @Author: chj
     * @Date: 2020/5/22
     */
     private PageInfo<User> selectPage(Integer pageNo, Integer pageSize,String username,Integer deptId){
        PageHelper.startPage(pageNo,pageSize);
         List<User> users = conditionsSelect(username, deptId);
         PageInfo<User> userPageInfo = new PageInfo<User>(users);
        return userPageInfo;
    }

    /** 方法描述 
    * @Description: 条件查询
     *                  是否根据  用户名和部门 查询
    * @Param: [username, deptId]
    * @return: java.util.List<com.eight.model.login.User>
    * @Author: chj
    * @Date: 2020/5/22
    */
    private  List<User> conditionsSelect(String username,Integer deptId) {
        List<User> users =null;
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.stringNotEmpty(username)) {
            criteria.andEqualTo("username",username);
        }
        if (NotEmpty.integerNotEmpty(deptId)) {
            criteria.andEqualTo("deptId",deptId);
        }
        try {
            users = userMapper.selectByExample(example);
        }catch (Exception e){
            return null;
        }
        return users;
    }

}
