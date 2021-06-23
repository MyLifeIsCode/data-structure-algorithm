package com.myself.jianzhioffer.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: SymmetryTree
 * @description: 对称二叉树 ，两个子树互为镜像
 * 如果同时满足下面的条件，两个树互为镜像：
 *
 * 它们的两个根结点具有相同的值。
 * 每个树的右子树都与另一个树的左子树镜像对称
 * @author: qll
 * @create: 2020-01-03 16:37
 **/
public class SymmetryTree {
    public static void main(String[] args) {

        SymmetryTree symmetryTree = new SymmetryTree();
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);

        TreeNode leftLeft = new TreeNode(3);

        TreeNode leftRight = new TreeNode(4);

        TreeNode right = new TreeNode(2);

        TreeNode rightLeft = new TreeNode(4);

        TreeNode rightRight = new TreeNode(3);
        root.left = left;
        left.left = leftLeft;
        left.right = leftRight;

        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;

        boolean symmetrical = symmetryTree.isSymmetrical(root);
        System.out.println(symmetrical);
    }
    public boolean isSymmetrical(TreeNode pRoot){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        queue.add(pRoot);
        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2==null) continue;
            if(t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }



   /* 以下方法不对
   *            1
   *        2       2
   *          3       3
   * 这种情况会报错
   *
   static Queue<Integer> leftQueue = new LinkedList<>();
    static Deque<Integer> rightQueue = new LinkedList<>();

    public boolean isSymmetrical(TreeNode pRoot){
        *//**
         * 1、左子树前序遍历与右子树后续遍历相同
         *//*
        leftQueue.clear();
        rightQueue.clear();
        before(pRoot.left);
        after(pRoot.right);
        if(leftQueue.isEmpty() && rightQueue.isEmpty()){
            return true;
        }
        if(leftQueue.size() != rightQueue.size()){
            return false;
        }else {
            while (!leftQueue.isEmpty()){
                if(leftQueue.poll().intValue() != rightQueue.pollLast().intValue()){
                    return false;
                }
            }
            return true;
        }
    }
    //前序
    public void before(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        leftQueue.add(treeNode.val);
        if(treeNode.left != null){
            before(treeNode.left);
        }
        if(treeNode.right != null){
            before(treeNode.right);
        }
    }
    //后序
    public void after(TreeNode treeNode){
        if(treeNode == null)
            return;
        if(treeNode.left != null){
            after(treeNode.left);
        }
        if(treeNode.right != null){
            after(treeNode.right);
        }
        rightQueue.offer(treeNode.val);
    }*/

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
