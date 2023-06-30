package com.example.springaop.aop;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-30-16:54:01
 */
public class CalculatorProxy implements Calculator{

    private Calculator calculator;

    public CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("执行前输出");
        int addResult = calculator.add(i,j);
        System.out.println(addResult);
        System.out.println("执行后输出");
        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("执行前输出");
        int subResult = calculator.add(i,j);
        System.out.println("执行后输出");
        return subResult;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("执行前输出");
        int mulResult = calculator.add(i,j);
        System.out.println("执行后输出");
        return mulResult;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("执行前输出");
        int divResult = calculator.add(i,j);
        System.out.println("执行后输出");
        return divResult;
    }
}
