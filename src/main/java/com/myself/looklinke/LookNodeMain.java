package com.myself.looklinke;

public class LookNodeMain {

    public static void main(String[] args) {
        LookNode n1 = new LookNode(1);
        LookNode n2 = new LookNode(2);
        LookNode n3 = new LookNode(3);
        LookNode n4 = new LookNode(4);
        LookNode n5 = new LookNode(5);

        n1.after(n2);
        n2.after(n3);
        n3.after(n4);
        n4.after(n5);
        System.out.println(n1.getNext().getData());
        System.out.println(n2.getNext().getData());
        System.out.println(n3.getNext().getData());
        System.out.println(n4.getNext().getData());
        System.out.println(n5.getNext().getData());
    }
}
