package com;

/**
 * @version v1.0
 * @Author zhy
 * Description 剑指 Offer 05. 替换空格
 */
public class LT1 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        StringBuilder s1 = new StringBuilder();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                s1.append("%20");
            }else{
                s1.append(s.charAt(i));
            }
        }

        String s2 = s1.toString();
        return s2;
    }


}
