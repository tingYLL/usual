package com.jdjm.zhy.utils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {
    /**
     *  获取HttpURLConnection链接对象
     * @param url  文件的地址
     * @return
     */
    public static HttpURLConnection getHttpURLConnection(String url) throws IOException {
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)httpUrl.openConnection();
        //向文件所在的服务器发送标识信息
        httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1");
        return httpURLConnection;
    }

    /**
     *  获取下载文件的名字
     * @param url
     * @return
     */
    public static String getHttpFileName(String url) {
        int index = url.lastIndexOf("/");
        return url.substring(index + 1);
    }


    /**
     * 分块下载
     * @param url 下载地址
     * @param startPos 文件下载起始位置
     * @param endPos  结束位置
     * @return
     */
    public static HttpURLConnection getHttpURLConnection(String url,long startPos,long endPos) throws IOException {
        HttpURLConnection httpURLConnection  = getHttpURLConnection(url);

        //结束位置不等于0说明是
        if(endPos !=0){
            httpURLConnection.setRequestProperty("RANGE","bytes="+startPos+"-"+endPos);
        }else{
            httpURLConnection.setRequestProperty("RANGE","bytes="+startPos+"-");
        }

        return httpURLConnection;
    }
}
