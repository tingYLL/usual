package com.example.springaop.aop;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-30-16:56:36
 */
public class CalculatorImpl implements Calculator{

    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }
}
