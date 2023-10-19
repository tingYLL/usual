package com.jdjm.zhy.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义日志工具类
 */
public class LogUtils {

    //打印正常的日志信息
    public static void info(String message,Object... args){
        print(message,"--info--",args);
    }

    //打印错误的日志信息
    public static void error(String message,Object... args){
        print(message,"--error--",args);
    }

    private static void print(String message,String level,Object... args){
        if(args!=null && args.length > 0){
            message = String.format(message.replace("{}", "%s"), args);
        }

        String threadName = Thread.currentThread().getName();
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " " + threadName + level + message);
    }
}
