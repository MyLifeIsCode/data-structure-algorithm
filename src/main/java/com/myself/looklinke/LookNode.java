package com.myself.looklinke;

import com.myself.linker.Node;

/**
 * 循环列表
 */
public class LookNode {

    private int data;
    private LookNode next;

    public LookNode(int data) {
        this.data = data;
        this.next = this;
    }

    public void after(LookNode node){
        LookNode nextNode = next;
        this.next = node;
        node.next = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LookNode getNext() {
        return next;
    }

    public void setNext(LookNode next) {
        this.next = next;
    }


}
