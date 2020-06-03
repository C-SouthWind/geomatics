package com.eight.service;

import com.eight.base.ResultData;
import com.eight.model.login.User;
import com.eight.model.manage.Dept;
import com.eight.model.manage.Dict;
import com.eight.model.manage.Menu;
import com.eight.model.manage.Role;
import com.eight.model.plotting.unit.*;
import com.eight.utils.NotEmpty;
import com.eight.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 20:32
 * @params :
 */
@FeignClient(value = "system-interface-provider")
public interface EightService {

    /**-------------------------------- 登录管理----->日志管理-----------------------------------------------*/



  /** 方法描述
    * @Description: 文件上传
    * @Param: [file]
    * @return: java.lang.Boolean
    * @Author: chj
    * @Date: 2020/5/29
    */
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean uploadFile(@RequestBody MultipartFile file);




    /** 方法描述
     * @Description: 执行登录操作
     * @Param: [user]
     * @return: com.chj.vo.TokenVo
     * @Author: chj
     * @Date: 2020/5/15
     */
    @PostMapping("/login/doLogin")
    TokenVo doLogin(@RequestBody User user);

   /** 方法描述 
   * @Description: 添加登录日志信息
   * @Param: [map]
   * @return: com.eight.base.ResultData
   * @Author: chj
   * @Date: 2020/5/27
   */
    @PostMapping("/loginLog/loginAddByMap")
    ResultData loginAddByMap(@RequestBody  Map map);

/**-------------------------------- 系统管理----->用户管理-----------------------------------------------*/

    /** 方法描述 
    * @Description:系统管理 -->用户管理  条件分页查询
    * @Param: [map]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/user/userSelectPage")
    ResultData userSelectPage(@RequestParam Map map);

    /** 方法描述
    * @Description: 系统管理--->用户管理
     *                  根据user表对象删除用户
    * @Param: [user]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/user/userDeleteByuser")
    ResultData userDeleteByuser(@RequestBody User user);


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                      根据user表对象新增用户
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/user/userInsertByUser")
    ResultData userInsertByUser(@RequestBody User user);


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                      根据user表  查询单个信息
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/user/userSelectOneByUser")
    ResultData userSelectOneByUser(@RequestBody User user);


    /** 方法描述
     * @Description: 系统管理--->用户管理
     *                  根据user表  修改信息
     * @Param: [user]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/user/userUpdateByUser")
    ResultData userUpdateByUser(@RequestBody User user);


    /** 方法描述
    * @Description: 系统管理--->用户管理
     *                      根据user表 密码重置
    * @Param: [user]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/22
    */
    @PostMapping("/user/userResetPassword")
     ResultData userResetPassword(@RequestBody User user);

/**-------------------------------- 系统管理----->字典管理-----------------------------------------------*/

    /** 方法描述
     * @Description: 分页条件查询
     *                  系统管理--->字典管理       dict表
     * @Param: [map]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dict/dictSelectPage")
     ResultData dictSelectPage(@RequestParam Map map);

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      新增dict表
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dict/dictInsertByDict")
    ResultData dictInsertByDict(@RequestBody Dict dict);


    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      删除dict表数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dict/dictDeleteByDict")
    ResultData dictDeleteByDict(@RequestBody Dict dict);

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      查询dict表单个数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dict/dictSelectOneByDict")
    ResultData dictSelectOneByDict(@RequestBody Dict dict);

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      修改dict表单个数据
     * @Param: [dict]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dict/dictUpdateByDict")
    ResultData dictUpdateByDict(@RequestBody Dict dict);

/**-------------------------------- 系统管理----->部门管理-----------------------------------------------*/
    /** 方法描述
     * @Description: 分页条件查询
     *                  系统管理--->部门管理       dept表
     * @Param: [map]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptSelectPage")
    ResultData deptSelectPage(@RequestParam Map map);

    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      新增dept表
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptInsertByDept")
    ResultData deptInsertByDept(@RequestBody Dept dept);


    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      删除dept表数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptDeleteByDept")
    ResultData deptDeleteByDept(@RequestBody Dept dept);

    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      查询dept表单个数据
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptSelectOneByDept")
    ResultData deptSelectOneByDept(@RequestBody Dept dept);

    /** 方法描述
     * @Description: 系统管理--->部门管理
     *                      修改dept表单个数据
     * @Param: [dept]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dept/deptUpdateByDept")
    ResultData deptUpdateByDept(@RequestBody Dept dept);


    /**-------------------------------- 系统管理----->菜单管理-----------------------------------------------*/

    /** 方法描述
     * @Description: 分页条件查询
     *                      系统管理--->菜单管理       menu表
     * @Param: [map, redisService]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/menuSelect")
    ResultData menuSelect(@RequestParam Map map);

    /** 方法描述
     * @Description: 系统管理--->菜单管理
     *                      删除menu表数据
     * @Param: [role]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/menuDeleteByMenu")
    ResultData menuDeleteByMenu(@RequestBody Menu menu);

    /** 方法描述
     * @Description: 系统管理--->菜单管理
     *                      根据menu表  查询单个信息
     * @Param: [menu]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/menuSelectOneByMenu")
    ResultData menuSelectOneByMenu(@RequestBody Menu menu);


    /**-------------------------------- 系统管理----->角色管理-----------------------------------------------*/

    /** 方法描述
     * @Description: 分页条件查询
     *                      系统管理--->角色管理       role表
     * @Param: [map, redisService]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/roleSelect")
    ResultData roleSelect(@RequestParam Map map);

    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      删除role表数据
     * @Param: [role]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/roleDeleteByRole")
    ResultData roleDeleteByRole(@RequestBody Role role);


    /** 方法描述
     * @Description: 系统管理--->角色管理
     *                      根据role表  查询单个信息
     * @Param: [role]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/22
     */
    @PostMapping("/roleSelectOneByRole")
    ResultData roleSelectOneByRole(@RequestBody Role role);
    
     /**-------------------------------- 测绘管理----->查询单位基本信息-----------------------------------------------*/
    
    /**
    * @Description: 查询单位基本信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    @PostMapping("/selectUnit")
    ResultData selectUnit(@RequestBody Unit unit);

    /**
    * @Description: 查询法人信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    @PostMapping("/selectPrincipal")
    ResultData selectPrincipal(@RequestBody Principal principal);

    /**
    * @Description: 查询技术人员信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    @PostMapping("/selectTechnicist")
    ResultData selectTechnicist(@RequestBody Technicist technicist);

    /**
    * @Description: 查询仪器设备
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    @PostMapping("/selectEquipment")
    ResultData selectEquipment(@RequestBody Equipment equipment);

    /**
     * @Description: 查询特殊岗位
     * @Param:
     * @return:
     * @Author: hxy
     * @Date: 2020/5/30
     */

    @PostMapping("/selectSpecialPost")
    ResultData selectSpecialPost(@RequestBody SpecialPost specialpost);

    /**-------------------------------- xx管理----->xxx管理-----------------------------------------------*/

}
