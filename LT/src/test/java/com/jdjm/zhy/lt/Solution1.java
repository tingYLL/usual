package com.jdjm.zhy.lt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-14-22:56:08
 */

@SpringBootTest
public class Solution1 {

    public static void main(String[] args) {
        int i = new Solution1().strToInt("42");
        System.out.println(i);
    }

    @Test
    public int strToInt(String str) {

        char[] chars = str.trim().toCharArray();
        if(chars.length == 0) return 0;

        int res = 0;
        int flag = 1;
        int b = Integer.MAX_VALUE/10;
        int j = 0;
        if(chars[0] == '-'){
            flag = -1;
            j = 1;
        }

        if(chars[0] == '+'){
            j = 1;
        }

        for(int i = j;i < chars.length;i++){
            if(chars[i] > '9' || chars[i] < '0') break;
            int x  = chars[i] - '0';
            if(res > b||(res == b&&chars[i]>7)) return flag == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = x+res*10;
        }

        return res*flag;
    }
}
