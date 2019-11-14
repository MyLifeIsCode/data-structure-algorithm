package com.myself.linker;

public class OneLink {

    public static void main(String[] args) {
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,null);

        node1.after(node2);
        System.out.println(node1.getNext().getData());
    }
}
