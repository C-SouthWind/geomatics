package com.eight.utils;

import java.util.Random;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 18:53
 * @params :
 */
public class FileNameUtils {

    private FileNameUtils() {

    }

    /** 方法描述
    * @Description: 文件名的生成方法
    * @Param: []
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/29
    */
    public static String getFileName() {
        // 1.获取系统当前时间的毫秒数
        Long timeMillis = System.currentTimeMillis();
        // 2.创建Random对象
        Random random = new Random();
        // 3.随机0-999之间随机
        Integer randomNum = random.nextInt(999);
        System.out.println(randomNum);
        // 4.生成文件名

        String fileName = timeMillis + String.format("%03d", randomNum);
        System.out.println(fileName);
        // 5.返回文件名称
        return fileName;
    }

}
