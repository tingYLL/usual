package com.jdjm1.MyTest;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 */
public class StaticBind {
    public int i =10;

    public static void main(String[] args) {
        StaticBind staticBind = new StaticBindSub();
        staticBind.i = staticBind.i+1;
        System.out.println(staticBind.i);
    }
}

class StaticBindSub extends StaticBind{
    public int i = 100;

    public StaticBindSub() {
        i = super.i+i;
    }
}
