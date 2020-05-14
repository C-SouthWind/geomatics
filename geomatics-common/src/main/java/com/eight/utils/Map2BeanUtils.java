package com.eight.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：chj
 * @date ：Created in 2020/5/14 15:13
 * @params :map和bean之间的转换
 */
public class Map2BeanUtils{
    
    private Map2BeanUtils(){}
    
    private final static Objenesis OBJENESIS = new ObjenesisStd(true);
    private final static StringBuffer STRING_BUFFER = new StringBuffer();
    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP = new ConcurrentHashMap<Class, MethodAccess>();
    
    
    /** 方法描述 
    * @Description: 把map转为bean对象
    * @Param: [map, tClass]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/14
    */
    public static <T> T map2Bean(Map<String,Object> map , Class<T> tClass){
        T instance = OBJENESIS.newInstance(tClass);
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(tClass);
        if (null == methodAccess) {
           methodAccess = MethodAccess.get(tClass);
           CONCURRENT_HASH_MAP.putIfAbsent(tClass,methodAccess);
        }
        for(Map.Entry<String,Object> entry:map.entrySet()){
            String setMethodName = setMethodName(entry.getKey());
            int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
            methodAccess.invoke(instance,index,entry.getValue());
        }
        return instance;
    }
    
    /** 方法描述 
    * @Description: 把字段拼接成set方法
    * @Param: [fieldName]
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/14
    */
    public static String setMethodName(String fieldName){
        return STRING_BUFFER.append("set").append(firstToUpperCase(fieldName)).toString();
    }
    
    
    /** 方法描述 
    * @Description: 把字段首字母转大写
    * @Param: [field]
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/14
    */
    public static String firstToUpperCase(String field){
        return field.substring(0,1).toUpperCase() + field.substring(1);
    }
}
