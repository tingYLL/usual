package com.jdjm.zhy.lt;

import java.util.ArrayList;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-15-00:07:27
 */
public class Solution3 {
    class Solution {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        public int[] reversePrint(ListNode head) {
            recur(head);
            int[] res = new int[tmp.size()];
            for(int i = 0; i < res.length; i++)
                res[i] = tmp.get(i);
            return res;
        }
        void recur(ListNode head) {
            if(head == null) return;
            recur(head.next);
            tmp.add(head.val);
        }
    }


}
