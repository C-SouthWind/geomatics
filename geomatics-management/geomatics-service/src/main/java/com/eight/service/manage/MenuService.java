package com.eight.service.manage;

import com.eight.mapper.manage.MenuMapper;
import com.eight.model.login.User;
import com.eight.model.manage.Menu;
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
 * @date ：Created in 2020/5/23 19:53
 * @params :
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      根据menu表  查询单个信息
     * @Param: [menu]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    public Menu menuSelectOneByMenu(Menu menu){
        if (NotEmpty.objectNotEmpty(menu)) {
            Menu menu1 = menuMapper.selectOne(menu);
            if (NotEmpty.objectNotEmpty(menu1)) {
                return menu1;
            }
        }
        return null;
    }




    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      删除menu表数据
     * @Param: [menu]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    public Integer menuDeleteByMenu(@RequestBody Menu menu){
        if (NotEmpty.objectNotEmpty(menu)) {
            int delete = menuMapper.delete(menu);
            if (NotEmpty.integerNotEmpty(delete)) {
                return delete;
            }
        }
        return null;
    }


    /** 方法描述
     * @Description: 分页条件查询
     *                   系统管理--->角色管理       menu表
     * @Param: [map, redisService]
     * @return: com.github.pagehelper.PageInfo<com.eight.model.manage.Menu>
     * @Author: chj
     * @Date: 2020/5/22
     */
    public List<Menu> roleSelect(Map map, RedisService redisService){
        //非空判断
        if (NotEmpty.mapNotEmpty(map)) {
            //拿到map中的值
            Object mn = map.get("menuName");
            Object pn = map.get("pageNo");
            Object ps = map.get("pageSize");
            String menuName = NotEmpty.objectNotEmpty(mn) ? mn.toString() : null;
            Integer pageNo = NotEmpty.objectNotEmpty(pn) ? Integer.parseInt(pn.toString()) : null;
            Integer pageSize = NotEmpty.objectNotEmpty(ps) ? Integer.parseInt(ps.toString()) : null;
            if (NotEmpty.integerNotEmpty(pageNo) && NotEmpty.integerNotEmpty(pageSize)) {
                //判断是否分页
                if (pageNo > 0 && pageSize > 0) {
                    return conditionsSelect(menuName);
                }
            }
            //默认第一页  每页十条 无条件
            return conditionsSelect(menuName);
        }
        //默认第一页  每页十条 无条件
        return conditionsSelect(null);
    }


    /** 方法描述
     * @Description: 条件查询
     *                  是否根据  名称 查询
     * @Param: [username, deptId]
     * @return: java.util.List<com.eight.model.manage.Menu>
     * @Author: chj
     * @Date: 2020/5/22
     */
    private List<Menu> conditionsSelect(String menuName) {
        List<Menu> menus =null;
        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        if (NotEmpty.stringNotEmpty(menuName)) {
            criteria.andEqualTo("menuName",menuName);
        }
        try {
            menus = menuMapper.selectByExample(example);
        }catch (Exception e){
            return null;
        }
        return menus;
    }

}
