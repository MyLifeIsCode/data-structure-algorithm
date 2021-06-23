package com.myself.jianzhioffer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MiddleNumTree
 * @description: 中位数计算
 * @author: qll
 * @create: 2020-01-07 11:18
 **/
public class MiddleNumTree {
    public static void main(String[] args) {
        MiddleNumTree middleNumTree = new MiddleNumTree();
        int[] arr = new int[]{5,2,3};
        for (int i = 0; i < arr.length; i++) {
            middleNumTree.Insert(arr[i]);
        }
        System.out.println(middleNumTree.GetMedian());
    }

    private TreeNode root = null;


    public void Insert(Integer num) {
        insert(root,num);
    }

    public Double GetMedian() {
        List<TreeNode> list = new ArrayList<>();
        middle(root,list);
        if(list.isEmpty()){
            return null;
        }
        int middle = list.size() / 2;

        if(list.size() % 2 == 0){
            Double val = Double.valueOf(list.get(middle).val) + Double.valueOf(list.get(middle - 1).val);
            return val / 2;
        }else {
            Double val =  Double.valueOf(list.get(middle).val);
            return val;
        }
    }
    //构建二叉树
    public void insert(TreeNode node,int val){
        if(root == null ){
            root = new TreeNode(val);
            return;
        }
        if(node != null){

        }

        if(node.val > val ){
            if(node.left != null){
                insert(node.left,val);
            }else {
                TreeNode leftNode = new TreeNode(val);
                node.left = leftNode;
            }

        }
        if(node.val <= val){
            if(node.right != null){
                insert(node.right,val);
            }else {
                TreeNode rightNode = new TreeNode(val);
                node.right = rightNode;
            }
        }

    }
    private List<TreeNode> middle(TreeNode node, List<TreeNode> list){
        if(node == null){
            return null;
        }
        if(node.left != null){
            middle(node.left,list);
        }
        list.add(node);
        if(node.right != null){
            middle(node.right,list);
        }
        return list;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
