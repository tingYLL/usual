package com.jdjm.zhy.core;

import com.jdjm.zhy.constant.Constant;
import com.jdjm.zhy.utils.HttpUtils;
import com.jdjm.zhy.utils.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;

public class Downloader {

    public void download(String url){
        //获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        //文件下载路径
        httpFileName = Constant.PATH + httpFileName;

        //获取连接对象
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = HttpUtils.getHttpURLConnection(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                InputStream input = httpURLConnection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(input);
                FileOutputStream fos = new FileOutputStream(httpFileName);
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            int len = -1;
            while ((len = bis.read()) != -1) {
                bos.write(len);
            }
        } catch (FileNotFoundException e) {
            LogUtils.error("下载的文件不存在{}",url);//下载的文件不存在
        } catch (Exception e) {
            LogUtils.error("下载失败");
        } finally {
            //关闭连接对象
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            LogUtils.info("下载完成");
        }


    }
}
