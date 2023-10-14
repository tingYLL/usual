package com.jdjm.zhy;

import com.jdjm.zhy.entity.Employee;
import com.jdjm.zhy.entity.MyDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@SpringBootTest
public class myTest1 {


    //遍历Map
    @Test
    public void testBianLiHashMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Heria");
        map.put(2,"Alex");
        map.put(3,"Jdjm");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("key是:"+entry.getKey()+",value是:"+entry.getValue());
        }
    }

    //使用TreeSet
    @Test
    public void testHowToUseTreeSet(){
        //注意TreeSet里写得泛型类型必须实现Comparable接口
        Set<Employee> set = new TreeSet<>();
        set.add(new Employee(1002,23,"C",new MyDate()));
        set.add(new Employee(1004,19,"A",new MyDate()));
        set.add(new Employee(1002,31,"E",new MyDate()));
        set.add(new Employee(1001,24,"Z",new MyDate()));
        set.add(new Employee(1008,24,"Y",new MyDate()));

        //输出的结果是按照自定义的排序规则进行排序的
        System.out.println(set);
    }
}
