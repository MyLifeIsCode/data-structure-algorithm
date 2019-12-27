package com.myself.tree.binary.linker;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure-algorithm->BinaryNode
 * @description: 二叉树结点
 * @author: qll
 * @create: 2019-12-17 11:10
 **/

@Data
public class BinaryNode {
    private Integer value;
    private BinaryNode leftNode;
    private BinaryNode rightNode;

    public BinaryNode(Integer value) {
        this.value = value;
    }

    public static BinaryNode build(){
        BinaryNode binaryNode1 = new BinaryNode(1);
        BinaryNode binaryNode2 = new BinaryNode(2);
        BinaryNode binaryNode3 = new BinaryNode(3);
        BinaryNode binaryNode4 = new BinaryNode(4);
        BinaryNode binaryNode5 = new BinaryNode(5);
        BinaryNode binaryNode6 = new BinaryNode(6);
        BinaryNode binaryNode7 = new BinaryNode(7);
        binaryNode1.setLeftNode(binaryNode2);
        binaryNode1.setRightNode(binaryNode3);

        binaryNode2.setLeftNode(binaryNode4);
        binaryNode2.setRightNode(binaryNode5);

        binaryNode3.setLeftNode(binaryNode6);
        binaryNode3.setRightNode(binaryNode7);

        return binaryNode1;
    }
    static List<Integer> list = new ArrayList<>();

    //前序遍历
    public static void before(BinaryNode binaryNode){

        //输出当前节点
        if(binaryNode == null){
            return;
        }
        list.add(binaryNode.getValue());
        System.out.println(binaryNode.getValue());
        //左节点
        if(binaryNode.getLeftNode() != null){
            before(binaryNode.getLeftNode());
        }
        if(binaryNode.getRightNode() != null){
            before(binaryNode.getRightNode());
        }
    }

    //中序遍历
    public static void middle(BinaryNode binaryNode){
        //输出当前节点
        if(binaryNode == null){
            return;
        }
        //左节点
        if(binaryNode.getLeftNode() != null){
            middle(binaryNode.getLeftNode());
        }
        System.out.println(binaryNode.getValue());
        if(binaryNode.getRightNode() != null){
            middle(binaryNode.getRightNode());
        }
    }

    //后续遍历
    public static void after(BinaryNode binaryNode){
        //输出当前节点
        if(binaryNode == null){
            return;
        }
        //左节点
        if(binaryNode.getLeftNode() != null){
            after(binaryNode.getLeftNode());
        }
        if(binaryNode.getRightNode() != null){
            after(binaryNode.getRightNode());
        }
        System.out.println(binaryNode.getValue());
    }


    //循环前序遍历
}
