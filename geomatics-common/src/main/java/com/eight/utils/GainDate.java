package com.eight.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author ：chj
 * @date ：Created in 2020/5/22 21:51
 * @params :
 */
public class GainDate {

    /** 方法描述 
    * @Description: 获取时间  年月日时分秒
    * @Param: []
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/22
    */
    public  static String getDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
