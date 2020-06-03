package com.eight.controller.manage;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.manage.Menu;
import com.eight.model.manage.Role;
import com.eight.redis.RedisService;
import com.eight.service.manage.MenuService;
import com.eight.service.manage.RoleService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 19:52
 * @params :
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RedisService redisService;

    /** 方法描述
     * @Description: 分页条件查询
     *                      系统管理--->菜单管理       menu表
     * @Param: [map, redisService]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/menuSelect")
    public ResultData menuSelect(@RequestParam Map map){
        List<Menu> menus = menuService.roleSelect(map, redisService);
        return NotEmpty.listNotEmpty(menus) ? selectSuccess(menus) : selectFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->菜单管理
     *                      删除menu表数据
     * @Param: [role]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/menuDeleteByMenu")
    public ResultData menuDeleteByMenu(@RequestBody Menu menu){
        Integer integer = menuService.menuDeleteByMenu(menu);
        return NotEmpty.integerNotEmpty(integer) ? deleteSuccess("删除"+integer+"条数据") : deleteFailed();
    }


    /** 方法描述
     * @Description: 系统管理--->菜单管理
     *                      根据menu表  查询单个信息
     * @Param: [menu]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/menuSelectOneByMenu")
    public ResultData menuSelectOneByMenu(@RequestBody Menu menu){
        Menu menu1 = menuService.menuSelectOneByMenu(menu);
        return NotEmpty.objectNotEmpty(menu1) ? selectSuccess(menu1) : selectFailed();
    }
}
