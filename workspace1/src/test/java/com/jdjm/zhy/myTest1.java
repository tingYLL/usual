package com.jdjm.zhy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class myTest1 {
    
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
}
