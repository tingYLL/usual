package com.jdjm.zhy;

import com.jdjm.zhy.entity.Employee;
import com.jdjm.zhy.entity.MyDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.*;

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

    @Test
    public void testStreamReduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
        Integer integer = reduce.get();

        System.out.println(list);
    }

    @Test
    public void testStreamReduce2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        int sum = 0;
        for (Integer a : list) {
            sum += a;
        }

        //a相当于sum  这里的0是赋初始值 相当于int sum = 0
        Integer result = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);

    }
}
