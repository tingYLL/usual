package com.jdjm.zhy.lt;

import java.util.ArrayList;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-15-00:46:15
 */
public class Solution4 {
    public static void main(String[] args) {

    }

    ArrayList<Integer> list = new ArrayList();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int arr[] = new int[list.size()];
        for(int i =0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void recur(ListNode node){
        if(node == null) return;
        recur(node.next);
        list.add(node.val);
    }
}
