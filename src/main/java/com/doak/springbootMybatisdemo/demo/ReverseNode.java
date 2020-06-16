package com.doak.springbootMybatisdemo.demo;

import com.doak.springbootMybatisdemo.entity.Node;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/4/25 21:15
 * @description：反转链表
 */
public class ReverseNode {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reverse1(node1);
        System.out.println(node1.pre);
        System.out.println(node2.pre);
        System.out.println(node3.pre);
    }

    public static void reverse1(Node head) {
        Node pre = null;
        Node curr = null;
        if (head.next != null) {
            pre = head.next;
            curr = head;

            curr.pre = pre;
            reverse1(head.next);
            head.next = null;
            pre.next = head;
        }
    }
}
