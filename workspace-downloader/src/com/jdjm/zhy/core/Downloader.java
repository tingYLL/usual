package com.jdjm.zhy.core;

import com.jdjm.zhy.constant.Constant;
import com.jdjm.zhy.utils.FileUtils;
import com.jdjm.zhy.utils.HttpUtils;
import com.jdjm.zhy.utils.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Downloader {

    public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public void download(String url){
        //获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        //文件下载路径
        httpFileName = Constant.PATH + httpFileName;



        //获取连接对象
        HttpURLConnection httpURLConnection = null;
        DownloadInfoThread downloadInfoThread = null;
        try {
            httpURLConnection = HttpUtils.getHttpURLConnection(url);
            long fileSize = FileUtils.getFileSize(httpFileName);
            if(fileSize >= httpURLConnection.getContentLength()){
                LogUtils.info("{}已下载，无需重复下载",httpFileName);
                return ;
            }
             downloadInfoThread = new DownloadInfoThread(httpURLConnection.getContentLength());
            scheduledExecutorService.scheduleAtFixedRate(downloadInfoThread,1,1, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                InputStream input = httpURLConnection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(input);
                FileOutputStream fos = new FileOutputStream(httpFileName);
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            byte[] buffer = new byte[Constant.BYTE_SIZE];
            int len = -1;
            while ((len = bis.read(buffer)) != -1) {
                downloadInfoThread.setCurSize(downloadInfoThread.getCurSize()+len);
                bos.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            LogUtils.error("下载的文件不存在{}",url);//下载的文件不存在
        } catch (Exception e) {
            LogUtils.error("下载失败");
        } finally {
            System.out.print("\r");
            System.out.print("下载完成");
            //关闭连接对象
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }

            //关闭
            scheduledExecutorService.shutdownNow();
        }
    }
}
