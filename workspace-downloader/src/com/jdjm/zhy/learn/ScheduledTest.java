package com.jdjm.zhy.learn;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTest {
    public static void main(String[] args) {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);

        /**
         * 延迟2s才执行，每3s执行一次。通过控制台输出可以看到当任务耗时为6s的时候，每3s执行一次的这3s 是会计算到任务执行时间的6s中的
         * 即任务一开始执行，3s的循环执行时间就已经开始计算了
         */
        s.scheduleAtFixedRate(()->{
            //模拟耗时操作
            try {
                TimeUnit.SECONDS.sleep(6);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },2,3,TimeUnit.SECONDS);
    }

    public static void  testScheduled(){
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
        s.schedule(()->{
            System.out.println(Thread.currentThread().getName());
        },2, TimeUnit.SECONDS);
        s.shutdown();
    }
}
