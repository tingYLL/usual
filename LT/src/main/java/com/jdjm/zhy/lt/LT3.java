package com.jdjm.zhy.lt;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-12-22:27:13
 */
public class LT3 {

    public static void main(String[] args) {
        LT3 lt3 = new LT3();
        int i = lt3.strToInt("        -42");
        System.out.println(i);
    }

    public int strToInt(String str) {

        char[] chars = str.trim().toCharArray();
        if(chars.length == 0) return 0;
        //flag代表信号量
        int flag = 1;

        //
        int j = 0;
        int res = 0;

        int b = Integer.MAX_VALUE/10;

        if(chars[0] == '-'){
            flag = -1;
            j = 1;
        }else if(chars[0] == '+'){
            flag = 1;
            j = 1;
        }

        for(int i = j;i<chars.length;i++){
            if(chars[i] < '0' || chars[i] > '9') break;
            int x = chars[i] - '0';

            if(res > b|| (res == b&&x>7))  return flag == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res*10+x;
        }

        return res*flag;

    }
}
