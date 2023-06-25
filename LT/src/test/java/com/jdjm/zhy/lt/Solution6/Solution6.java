package com.jdjm.zhy.lt.Solution6;

import java.util.HashMap;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-06-15-22:32:50
 */
public class Solution6 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while(cur != null){
            map.get(cur).next = map.get(cur.next);
           map.get(cur).random = map.get(cur.random);
           cur = cur.next;
        }


        cur = head;
        return map.get(cur);

    }
}
