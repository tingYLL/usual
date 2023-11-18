package com.jdjm.zhy.core;

import com.jdjm.zhy.constant.Constant;
import com.jdjm.zhy.utils.HttpUtils;
import com.jdjm.zhy.utils.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class DownloaderTask implements Callable<Boolean> {
    private String url;

    private long startPos;

    private long endPos;

    private int part;

    public DownloaderTask(String url, long startPos, long endPos, int part) {
        this.url = url;
        this.startPos = startPos;
        this.endPos = endPos;
        this.part = part;
    }


    @Override
    public Boolean call() throws Exception {
        String fileName = HttpUtils.getHttpFileName(url);
        //分块文件名
        fileName += fileName + ".temp"+part;
        //文件下载路径
        fileName += Constant.PATH+fileName;

        HttpURLConnection httpURLConnection = HttpUtils.getHttpURLConnection(url, startPos, endPos);

        try(
                InputStream input = httpURLConnection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(input);
                //RandomAccessFile可以将来用来实现断点下载功能
                RandomAccessFile accessFile = new RandomAccessFile(fileName,"ew");
                ) {
            byte[] buffer = new byte[Constant.BYTE_SIZE];
            int len = -1;
            while((len = bis.read(buffer))!=-1){
                accessFile.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            LogUtils.error("下载文件不存在{}",url);
        }catch (Exception e){
            LogUtils.error("下载出现异常");
        }

        return  null;
    }
}
