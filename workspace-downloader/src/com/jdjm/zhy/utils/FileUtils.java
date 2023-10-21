package com.jdjm.zhy.utils;


import java.io.File;

public class FileUtils {

    /**
     * 返回本地文件大小
     * @param url
     * @return
     */
    public static long getFileSize(String url){
        File file = new File(url);
        return file.exists()&&file.isFile()?file.length():0;
    }
}
