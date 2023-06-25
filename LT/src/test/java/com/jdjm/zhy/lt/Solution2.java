package com.jdjm.zhy.lt;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-14-23:45:19
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        LinkedList stack = new LinkedList();
        while(head != null){
            stack.add(head.val);
            head = head.next;
        }

        int [] arr = new int[stack.size()];
        for(int i = 0;i<arr.length;i++){
            arr[i] = (Integer)stack.removeLast();
        }
        return arr;
    }
}
