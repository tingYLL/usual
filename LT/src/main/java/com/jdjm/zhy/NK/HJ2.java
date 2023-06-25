package com.jdjm.zhy.NK;

import java.util.Scanner;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-13-17:13:41
 */
public class HJ2 {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        char [] arr1 = s1.toLowerCase().toCharArray();

        String s2 = sc.nextLine();
        char [] arr2 = s2.toLowerCase().toCharArray();

        for(int i = 0;i < s1.length();i++){
            if(arr1[i] == arr2[0]) count++;
        }

        System.out.println(count);
    }
}
