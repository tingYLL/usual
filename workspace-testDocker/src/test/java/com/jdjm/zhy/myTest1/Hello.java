package com.jdjm.zhy.myTest1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class Hello {

    @Test
    public void testString(){
        String s1 = "Hello,World,Java,";
        String[] arr1 = s1.split(",");
        System.out.println(Arrays.toString(arr1));
    }
}
