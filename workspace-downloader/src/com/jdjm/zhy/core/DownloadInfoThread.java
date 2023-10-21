package com.jdjm.zhy.core;

import com.jdjm.zhy.constant.Constant;

/**
 * 该线程用来输出下载信息
 */

public class DownloadInfoThread implements Runnable{

    //文件总大小
    private long fileSize;

    //每次下载大小 每次下载大小的意思是:Downloader中每次循环下载while ((len = bis.read(bytes)) != -1)后都会对这个值累加
    //注意是用volatile修饰的 因为这个变量会同时被输出下载信息和下载文件这两个线程使用
    private volatile double curSize;

    //(上一次的)每次下载大小
    private double preSize;

    //可用于断点下载
    private double finishedSize;

    public DownloadInfoThread(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setCurSize(double curSize) {
        this.curSize = curSize;
    }

    public void setPreSize(double preSize) {
        this.preSize = preSize;
    }

    public long getFileSize() {
        return fileSize;
    }

    public double getCurSize() {
        return curSize;
    }

    public double getPreSize() {
        return preSize;
    }

    @Override
    public void run() {
        //计算文件总大小 单位：mb
        String httpFileSize = String.format("%.2f", fileSize / Constant.MB);

        //计算每秒下载速度 kb(Downloader中while ((len = bis.read(bytes)) != -1)每次下载的单位是字节,所以这里需要除以1024以显示kb)
        int speed = (int)((curSize - preSize) / 1024d);
        preSize = curSize;

        //剩余文件的大小
        double remainSize = fileSize - finishedSize - curSize;

        //计算剩余时间
        String remainTime = String.format("%.1f", remainSize / 1024d / speed);
        //这个时间可能无限大，但是用户看不懂Infinity，所以返回"-"
        if ("Infinity".equalsIgnoreCase(remainTime)) {
            remainTime = "-";
        }

        //已下载大小
        String currentFileSize = String.format("%.2f", (curSize - finishedSize) / Constant.MB);

        String downInfo = String.format("已下载 %smb/%smb,速度 %skb/s,剩余时间 %ss",
                currentFileSize, httpFileSize, speed, remainTime);

        System.out.print("\r");
        System.out.print(downInfo);
    }
}
