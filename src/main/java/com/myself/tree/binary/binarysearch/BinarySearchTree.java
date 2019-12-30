package com.myself.tree.binary.binarysearch;

import com.myself.tree.binary.TreeNode;
import com.myself.tree.binary.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: jubian-cloud->BinarySearchTree
 * @description: 二叉搜索树
 * @author: qll
 * @create: 2019-12-27 15:34
 **/
public class BinarySearchTree {
    static TreeNode rootNode = null;
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,2,4,6,8};
//        int[] arr = {1,3};
        buildSearchTree(arr);
//        int height = rootNode.height(rootNode);
//        System.out.println(height);
//        levelOrder(rootNode);
//        after(rootNode);

//        TreeNode search = search(rootNode, 5);
//        System.out.println(search.toString());
    }


    /**
     * 构建二叉搜索树
     * @param arr
     * @return
     */
    public static TreeNode buildSearchTree(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insert(rootNode,arr[i]);
        }
        return rootNode;
    }
    /**
     * 插入数据
     * @param root
     * @param data
     */
    public static void insert(TreeNode root,int data){
        if(rootNode == null){
            TreeNode treeNode = new TreeNode();
            treeNode.setValue(data);
            rootNode = treeNode;
        }else {
            if(root.getValue() < data ){
                if( root.getRightNode() != null){
                    insert(root.getRightNode(),data);
                }else {
                    TreeNode rightNode = new TreeNode();
                    rightNode.setValue(data);
                    root.setRightNode(rightNode);
                }
            }else {
                if( root.getLeftNode() != null){
                    insert(root.getLeftNode(),data);
                }else {
                    TreeNode leftNode = new TreeNode();
                    leftNode.setValue(data);
                    root.setLeftNode(leftNode);
                }
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void before(TreeNode node){
        if(node != null){
            System.out.println(node.getValue());
            if(node.getLeftNode() != null){
                before(node.getLeftNode());
            }
            if(node.getRightNode() != null){
                before(node.getRightNode());
            }
        }
    }

    /**
     * 中序遍历,从小到大排序
     * @param node
     */
    public static void middle(TreeNode node){
        if(node != null){
            if(node.getLeftNode() != null){
                middle(node.getLeftNode());
            }
            System.out.println(node.getValue());
            if(node.getRightNode() != null){
                middle(node.getRightNode());
            }
        }
    }


    /**
     * 前序遍历
     * @param node
     */
    public static void after(TreeNode node){
        if(node != null){
            if(node.getLeftNode() != null){
                after(node.getLeftNode());
            }
            if(node.getRightNode() != null){
                after(node.getRightNode());
            }
            System.out.println(node.getValue());

        }
    }


    static Queue<TreeNode> queue = new LinkedList<>();
    static List<List<TreeNode>> rsList = new ArrayList<>();
    /**
     * 层次遍历
     * @param node
     */
    public static void levelOrder(TreeNode node){
        queue.offer(node);
        queue.offer(null);
        List<TreeNode> tempList = new ArrayList<>();
        rsList.add(tempList);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode!=null){
                tempList.add(treeNode);
                if(treeNode.getLeftNode() != null){
                    queue.offer(treeNode.getLeftNode());
                }
                if(treeNode.getRightNode() != null){
                    queue.offer(treeNode.getRightNode());
                }

            }else {
                if(!queue.isEmpty()){
                    tempList = new ArrayList<>();
                    rsList.add(tempList);
                    queue.offer(null);
                }
            }
        }
        rsList.forEach(treeNodes -> {
            treeNodes.forEach(treeNode -> {
                System.out.printf(treeNode.getValue() + ",");
            });
            System.out.println("-------------------");
        });
    }

    /**
     * 查询数据
     * @param treeNode
     * @param data
     * @return
     */
    public static TreeNode search(TreeNode treeNode,int data){
        if(treeNode == null){
            return null;
        }else {
            if(data == treeNode.getValue()){
                return treeNode;
            }else if(data > treeNode.getValue()){
                return search(treeNode.getRightNode(),data);
            }else {
                return search(treeNode.getLeftNode(),data);
            }
        }
    }
}
