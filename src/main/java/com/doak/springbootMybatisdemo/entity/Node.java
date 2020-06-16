package com.doak.springbootMybatisdemo.entity;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/4/25 21:35
 * @description：结点
 */
public class Node {
    public Node pre;
    public Node next;
    public int num;

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("num=").append(num);
        sb.append('}');
        return sb.toString();
    }
}
