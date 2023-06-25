package com.jdjm.zhy.lt.LT4;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @Author zhy
 * Description 复制链表
 * @Date 2023-06-25-23:50:17
 */
public class LT4 {
    public static void main(String[] args) {

    }

    public Node copyList(Node head) {
        Node node1 = new Node(0);
        Node node2 = node1;
        Node cur =head;
        while(cur != null){
            node2.next = new Node(cur.val);
            cur = cur.next;
            node2 = node2.next;
        }
        return node1.next;
    }
}
