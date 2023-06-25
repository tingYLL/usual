package com.jdjm.zhy.lt;

/**
 * @version v1.0
 * @Author zhy
 * Description 剑指 Offer 58 - II. 左旋转字符串
 * @Date 2023-06-12-21:49:14
 */
public class LT2 {
    public static void main(String[] args) {
        LT2 lt2 = new LT2();
        String res = lt2.reverseLeftWords("abcdefg", 2);
        System.out.println(res);
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(int i=0;i<n;i++){
            s1.append(s.charAt(i));
        }

        for(int i = n;i < s.length();i++){
            s2.append(s.charAt(i));
        }

        String res = s2.toString()+s1.toString();
        return res;
    }
}
