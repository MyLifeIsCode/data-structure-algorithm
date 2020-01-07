package com.myself.tree.binary.avl;

import com.myself.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: jubian-cloud->AvlTree
 * @description: 平和二叉树
 * @author: qll
 * @create: 2019-12-27 17:53
 **/
public class AvlTree {
    TreeNode rootNode = null;
    public static void main(String[] args) {

        AvlTree avlTree = new AvlTree();
//        int[] arr = {1,3,5,7,9,2,4,6,8};
        //左左
//        int[] arr = {7,6,5};
        //右右
//        int[] arr = {5,7,6,9};
        //左右
//        int[] arr = {7,5,6};
        //右左
        int[] arr = {2,5,4};
        avlTree.rootNode = avlTree.buildSearchTree(avlTree.rootNode,arr);
//        System.out.println(avlTree.rootNode);
        avlTree.levelOrder(avlTree.rootNode);

    }

    /**
     * 构建平衡二叉搜索树
     * @param arr
     * @return
     */
    public TreeNode buildSearchTree(TreeNode rootNode,int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(rootNode == null){
                rootNode = new TreeNode();
                rootNode.setValue(arr[i]);
            }else {
                rootNode = insert(rootNode, arr[i]);
            }
        }
        return rootNode;
    }


    /**
     * 插入数据
     * @param parent 插入节点的parent
     * @param data
     */
    public TreeNode insert(TreeNode parent,int data){
        if(parent == null){
            TreeNode treeNode = new TreeNode();
            treeNode.setValue(data);
            parent = treeNode;
        }else {
            //右
            if(parent.getValue() < data ){
                if( parent.getRightNode() != null){
                    insert(parent.getRightNode(),data);
                }else {
                    TreeNode rightNode = new TreeNode();
                    rightNode.setValue(data);
                    parent.setRightNode(rightNode);
                }
                if(height(parent.getRightNode()) - height(parent.getLeftNode()) > 1){
                    if(data > parent.getRightNode().getValue()){
                        //右右
                        TreeNode newParent = rightRightRotate(parent);
                        parent = newParent;
                    }else {
                        //右左
                        TreeNode newParent = rightLeftRotate(parent);
                        parent = newParent;
                    }
                }
            }else {
                //左
                if( parent.getLeftNode() != null){
                    insert(parent.getLeftNode(),data);
                }else {
                    TreeNode leftNode = new TreeNode();
                    leftNode.setValue(data);
                    parent.setLeftNode(leftNode);
                }
                if(height(parent.getLeftNode()) - height(parent.getRightNode()) > 1){
                    if(data < parent.getLeftNode().getValue()){
                        //左左
                        TreeNode newParent = leftLeftRotate(parent);
                        parent = newParent;
                    }else {
                        //左右
                        TreeNode newParent = leftRightRotate(parent);
                        parent = newParent;
                    }
                }
            }
        }
        return parent;
    }


    /**
     * 计算节点高度
     * @param node
     * @return
     */
    public Integer height(TreeNode node){
        if(node == null){
            return 0;
        }
        Integer lHeight = height(node.getLeftNode());
        Integer rHeight = height(node.getRightNode());
        return lHeight >= rHeight ? lHeight + 1 : rHeight + 1;
    }

    /**
     * LL 左左旋转
     * @param parent
     * @return
     */
    public static TreeNode leftLeftRotate(TreeNode parent){
        TreeNode newNode = parent.getLeftNode();
        //以下两行代码顺序不能改 *****
        parent.setLeftNode(newNode.getRightNode());
        newNode.setRightNode(parent);
        return newNode;
    }

    /**
     * RR 右右旋转
     * @param parent
     * @return
     */
    public TreeNode rightRightRotate(TreeNode parent){
        TreeNode newNode = parent.getRightNode();
        parent.setRightNode(newNode.getLeftNode());
        newNode.setLeftNode(parent);
        return newNode;
    }

    /**
     * LR 左右旋转,先右右左子节点，再左左
     * @param parent
     * @return
     */
    public TreeNode leftRightRotate(TreeNode parent){
        TreeNode treeNode = rightRightRotate(parent.getLeftNode());
        parent.setLeftNode(treeNode);
        return leftLeftRotate(parent);
    }

    /**
     * RL 右左旋转,先左左右子节点，再右右
     * @param parent
     * @return
     */
    public TreeNode rightLeftRotate(TreeNode parent){
        TreeNode treeNode = leftLeftRotate(parent.getRightNode());
        parent.setRightNode(treeNode);
        return rightRightRotate(parent);
    }

    static Queue<TreeNode> queue = new LinkedList<>();
    static List<List<TreeNode>> resList = new ArrayList<>();
    public void levelOrder(TreeNode node){
        queue.offer(node);
        queue.offer(null);
        List<TreeNode> tempList = new ArrayList<>();
        resList.add(tempList);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll != null){
                tempList.add(poll);
                if(poll.getLeftNode()!= null){
                    queue.offer(poll.getLeftNode());
                }
                if(poll.getRightNode() != null){
                    queue.offer(poll.getRightNode());
                }
            }else {
                if(!queue.isEmpty()){
                    tempList = new ArrayList<>();
                    resList.add(tempList);
                    queue.offer(null);
                }
            }
        }
        for (List<TreeNode> treeNodes : resList) {
            for (TreeNode treeNode : treeNodes) {
                System.out.print(treeNode.getValue() + ",");
            }
            System.out.println();
            System.out.println("---------------------------------------");
        }
    }
}
