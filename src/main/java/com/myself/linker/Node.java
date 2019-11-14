package com.myself.linker;

/**
 * 单项链表
 */
public class Node {
    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    private Integer data;
    private Node next;

    /**
     * 追加节点
     * @param node
     */
    public void after(Node node){
        this.next = node;
    }


    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
