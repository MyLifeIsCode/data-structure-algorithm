package com.myself.tree.binary.linker;


/**
 * @program: data-structure-algorithm->BinaryTree
 * @description:
 * @author: qll
 * @create: 2019-12-17 11:02
 **/
public class BinaryTree {


    public static void main(String[] args) {
        BinaryNode root = BinaryNode.build();
//        BinaryNode.before(root);
//        root.middle(root);
        root.after(root);
    }
}
