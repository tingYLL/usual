package com.jdjm.zhy;

import com.jdjm.zhy.core.Downloader;
import com.jdjm.zhy.utils.LogUtils;
import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        String url = "";
        //运行这个java程序的时候，允许用户在使用命令运行的时候，在后面直接携带url
        //如果运行java程序的命令后面没有携带url，就从控制台中读取
        if(args == null ||args.length == 0){
            for(;;){
                LogUtils.info("请输入下载链接:");
                Scanner scanner = new Scanner(System.in);
                url = scanner.next();
                if(url != null){
                    break;
                }
            }
        }
        //运行这个程序的java命令后面携带url，直接读取就行
        else{
            url = args[0];
        }
        Downloader downloader = new Downloader();
        downloader.download(url);
    }


}
