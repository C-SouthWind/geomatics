package com.eight.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author ：chj
 * @date ：Created in 2020/5/14 15:07
 * @params :
 */
public class SpringContextUtils implements ApplicationContextAware {

    private SpringContextUtils(){}

    private static ApplicationContext APPLICATIONCONTEXT = null;
    private static final ReadWriteLock READ_WRITE_LOCK = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATIONCONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        Lock lock = READ_WRITE_LOCK.readLock();
        lock.lock();
        try {
           return null != APPLICATIONCONTEXT ? APPLICATIONCONTEXT:null;
        }finally {
            lock.unlock();
        }
    }
}
