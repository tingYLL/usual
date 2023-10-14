package com.jdjm.zhy.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.jdjm.zhy.annotation.CustomAnnotation");
        Method[] methods = aClass.getMethods();
        for(Method method:methods){
            //如果方法上面带有myAnnotation这个注解
            boolean bool = method.isAnnotationPresent(myAnnotation.class);
//            System.out.println("method:"+method+":"+bool);
            if(bool){

                //第一个参数是要调用方法的对象;第二个参数是方法的参数（可选
                method.invoke(aClass.getConstructor(null).newInstance(null),"jdjm");
//                method.invoke(new CustomAnnotation(),"jdjm");
            }

        }
    }
}
