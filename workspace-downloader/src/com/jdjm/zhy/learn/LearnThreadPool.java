package com.jdjm.zhy.learn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LearnThreadPool {
    public static void main(String[] args) throws InterruptedException {
        testPool2();
    }

    public static void testPool2() throws InterruptedException {
        ThreadPoolExecutor threadPool = null;
        try {
            //创建线程池对象
//        ThreadPoolExecutor threadPool2 = new ThreadPoolExecutor(2, 3, 1,
//                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
//                (x)->{
//                    Thread thread = new Thread();
//                    return thread;
//                });

            //创建线程池对象
            threadPool = new ThreadPoolExecutor(2, 3, 1,
                    TimeUnit.MINUTES, new ArrayBlockingQueue<>(2));

            //创建任务
            Runnable runnable = ()->{
                System.out.println(Thread.currentThread().getName());
            };

            //往线程池提交了6个任务 会触发拒绝策略
            for (int i = 0; i < 6; i++) {
                threadPool.execute(runnable);
            }
//        threadPool.execute(runnable);
        } finally {
            if(threadPool != null){
                //温和地关闭
                threadPool.shutdown();

                //如果线程池使用温柔地关闭 一分钟后还没关闭成功,就会执行强制关闭
                if(!threadPool.awaitTermination(1,TimeUnit.MINUTES)){
                    threadPool.shutdownNow();
                }

            }
        }

    }
}
