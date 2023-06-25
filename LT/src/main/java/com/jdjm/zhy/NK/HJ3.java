package com.jdjm.zhy.NK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @version v1.0
 * @Author zhy
 * Description HJ3 随机数
 * @Date 2023-06-13-14:07:26
 */
public class HJ3 {
    public static void main(String[] args) {
        int res = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int [] arr = new int[a];
        for(int i =0;i<a;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i = 0;i< arr.length;i++){
            if(arr[i] > res){
                res =arr[i];
                arrayList.add(arr[i]);
            }
        }

        for(int i =0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
