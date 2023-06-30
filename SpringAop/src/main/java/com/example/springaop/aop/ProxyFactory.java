package com.example.springaop.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-30-17:11:35
 */
public class ProxyFactory {
    //目标对象 如CalculatorImpl的对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     *  Proxy.newProxyInstance()有三个参数
     *
     *  第一个参数：ClassLoader
     *  第二个参数：Class[] interfaces:目标对象实现的所有接口的class类型数组
     *  第三个参数：InvocationHandler：设置代理对象实现目标对象方法的过程
     * @return
     */
    //返回代理对象
    public Object getProxy(){
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler =  new InvocationHandler(){

            /**
             *
             * @param proxy 代理对象
             * @param method 需要重写目标对象的方法(比如CalculatorImpl中的加减乘除方法，如果
             *               不用代理处理，每个计算的方法中都要手动加上日志代码，这里的method就是加减乘除方法)
             * @param args  method方法里的参数

             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[动态代理][日志]"+method.getName()+"方法,参数"+ Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志]"+method.getName()+"方法,结果"+ result);
                } catch(Exception e){
                    e.printStackTrace();
                    System.out.println("[动态代理][日志]"+method.getName()+",异常"+ e.getMessage());
                }finally {
                    System.out.println("[动态代理][日志]"+method.getName()+"方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
