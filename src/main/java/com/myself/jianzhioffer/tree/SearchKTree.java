package com.myself.jianzhioffer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SearchKTree
 * @description: 查找第级小的树
 * @author: qll
 * @create: 2020-01-07 10:35
 **/
public class SearchKTree {
    public static void main(String[] args) {
//        {8,6,10,5,7,9,11}
        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode leftLeft = new TreeNode(5);
        TreeNode leftRight = new TreeNode(7);
        TreeNode right = new TreeNode(10);
        TreeNode rightLeft = new TreeNode(9);
        TreeNode rightRight = new TreeNode(11);
        root.left = left;
        left.left = leftLeft;
        left.right = leftRight;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        SearchKTree searchKTree = new SearchKTree();
        TreeNode treeNode = searchKTree.KthNode(root, 0);
        System.out.println(treeNode.val);

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        List<TreeNode> list = new ArrayList<>();
        middle(pRoot,list);
        if(list == null || k > list.size() || k<=0){
            return null;
        }
        return list.get(k-1);
    }
    private List<TreeNode> middle(TreeNode node,List<TreeNode> list){
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
