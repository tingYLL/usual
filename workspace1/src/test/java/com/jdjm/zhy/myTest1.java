package com.jdjm.zhy;

import com.jdjm.zhy.entity.Employee;
import com.jdjm.zhy.entity.MyDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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

    //使用Stream流做规约 reduce操作
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


    //使用Stream流做分组操作
    @Test
    public void testStreamGroup(){
        List<String> list = Arrays.asList("apple","banana","orange");
        Map<Integer,List<String>> map = new HashMap<>();
        for (String s : list) {
            int length = s.length();
            if(!map.containsKey(length)){
                map.put(length,new ArrayList<>());
            }
            map.get(length).add(s);
        }

        //下面这行操作等价于上面的
        Map<Integer, List<String>> map2 = list.stream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(map);
        System.out.println(map2);
    }

    //Optional , filter操作
    @Test
    public void test3(){
        String s = "hello world!";
        List<String> list = Arrays.asList("apple","banana","orange");
        if(s!=null){
            System.out.println(s.toUpperCase());
        }

        //下面的 操作等价于上面3行
        Optional.ofNullable(s).map(x->x.toUpperCase()).ifPresent(System.out::println);

        List<String> a = list.stream().filter(x -> x.startsWith("a")).map(x -> x.toUpperCase()).sorted().collect(Collectors.toList());
    }

    //Collections.sort()方法
    public void test4(){


        List<String> list = Arrays.asList("apple","banana","orange");

        //接下来要为list定义一个排序规则

        //传统写法
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        //lambda写法
        Collections.sort(list,(o1,o2)->o1.compareTo(o2));
    }
}
