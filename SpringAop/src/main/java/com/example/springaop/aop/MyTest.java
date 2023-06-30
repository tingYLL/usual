package com.example.springaop.aop;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-30-17:03:10
 */
public class MyTest {
    public static void main(String[] args) {
        CalculatorProxy Proxy = new CalculatorProxy(new CalculatorImpl());
        Proxy.add(1,2);

        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);

    }
}
