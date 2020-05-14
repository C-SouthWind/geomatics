package com.eight.base;

import com.eight.utils.Map2BeanUtils;
import com.eight.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/14 14:40
 * @params :
 */
public abstract class BaseService<T> {

    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;
    
    /** 方法描述 
    * @Description: 使子类可以继承自己写的方法
    * @Param: []
    * @return: tk.mybatis.mapper.common.Mapper
    * @Author: chj
    * @Date: 2020/5/14
    */
    protected Mapper getMapper(){
        return mapper;
    }
    
    /** 方法描述 
    * @Description: 新增
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/14
    */
    public Integer add(T t)throws Exception{
        return mapper.insertSelective(t);
    }
    
    /** 方法描述 
    * @Description: 通过主键删除
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/14
    */
    public Integer delete(T t) throws Exception{
        return mapper.deleteByPrimaryKey(t);
    }

    /** 方法描述
    * @Description: 获取子类泛型类型
    * @Param: []
    * @return: java.lang.Class<T>
    * @Author: chj
    * @Date: 2020/5/14
    */
    private Class<T> getTypeArguement(){
        if (null == cache) {
            cache = (Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return cache;
    }

    /** 方法描述
    * @Description: 通过主键批量删除
    * @Param: [ids]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/14
    */
    public Integer delete(List<Object> ids) throws Exception{
        Example ex = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(ex);
    }

    /** 方法描述
    * @Description:  更新功能
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/14
    */
    public Integer update(T t) throws  Exception{
        return mapper.updateByPrimaryKeySelective(t);
    }

    /** 方法描述
    * @Description: 批量更新
    * @Param: [t, ids]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/14
    */
    public Integer batchUpdate(T t,Object[] ids) throws Exception{
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }

    /** 方法描述
    * @Description: 查询一条数据
    * @Param: [t]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/14
    */
    public T queryOne(T t) throws Exception{
        return mapper.selectOne(t);
    }

    /** 方法描述
    * @Description: 封装条件查询，分页查询以及排序查询的通用方法(多条件查询)
    * @Param: [pageNo, pageSize, where, orderByField, field]
    * @return: java.util.List<T>
    * @Author: chj
    * @Date: 2020/5/14
    */
    private List<T> queryByFieldBase(Integer pageNo,Integer pageSize,Sqls where,String orderByField,String... field){
        Example.Builder builder = null;
        builder =  null == field || field.length==0 ? Example.builder(getTypeArguement()):Example.builder(getTypeArguement()).select(field);
        if (null != orderByField) {
            builder = builder.orderByDesc(orderByField);
        }
        Example example = builder.build();

        if (null != pageNo && null != pageSize) {
            PageHelper.startPage(pageNo,pageSize);
        }
        List list = getMapper().selectByExample(example);
        return list;
    }
    
    /** 方法描述 
    * @Description: 通过指定字段查询一条数据
    * @Param: [where, orderbyField, fields]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/14
    */
    public T queryByField(Sqls where , String orderbyField,String... fields) throws Exception{
        return queryByFieldBase(null,null,where,orderbyField,fields).get(0);
    }
    
    /** 方法描述 
    * @Description: 条件查询集合
    * @Param: [where, orderByField, fields]
    * @return: java.util.List<T>
    * @Author: chj
    * @Date: 2020/5/14
    */
    public List<T> queryListByFields(Sqls where ,String orderByField,String... fields) throws Exception{
        return queryByFieldBase(null,null,where,orderByField,fields);
    }
    
    /** 方法描述 
    * @Description: 条件查询分页
    * @Param: [pageNo, pageSize, where, orderByFileds, fields]
    * @return: com.github.pagehelper.PageInfo<T>
    * @Author: chj
    * @Date: 2020/5/14
    */
    public PageInfo<T> queryListByPageAndFields(Integer pageNo,Integer pageSize,Sqls where ,String orderByFileds,String... fields){
        return new PageInfo<T>(queryByFieldBase(pageNo,pageSize,where,orderByFileds,fields));
    }
    
    /** 方法描述 
    * @Description: 条件查询
    * @Param: [t]
    * @return: java.util.List<T>
    * @Author: chj
    * @Date: 2020/5/14
    */
    public List<T> queryList(T t) throws Exception{
        return mapper.select(t);
    }

    /** 方法描述
    * @Description: 分页查询
    * @Param: [t, pageNo, pageSize]
    * @return: com.github.pagehelper.PageInfo<T>
    * @Author: chj
    * @Date: 2020/5/14
    */
    public PageInfo<T> queryListByPage(T t,Integer pageNo ,Integer pageSize) throws Exception{
        PageHelper.startPage(pageNo,pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /** 方法描述
    * @Description: 获取Spring容器
    * @Param: []
    * @return: org.springframework.context.ApplicationContext
    * @Author: chj
    * @Date: 2020/5/14
    */
    public ApplicationContext getApplicationContext(){
        return SpringContextUtils.getApplicationContext();
    }

    /** 方法描述
    * @Description: 根据反射获取实例对象
    * @Param: [map]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/14
    */
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map,getTypeArguement());
    }
}
