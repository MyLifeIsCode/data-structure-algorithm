package com.myself.jianzhioffer.tree;

import java.util.*;

/**
 * @program: jubian-cloud->ZPrintTree
 * @description: Z字打印二叉树
 * @author: qll
 * @create: 2020-01-06 09:29
 **/
public class ZPrintTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);

        TreeNode leftLeft = new TreeNode(4);

        TreeNode leftRight = new TreeNode(5);

        TreeNode right = new TreeNode(3);

        TreeNode rightLeft = new TreeNode(6);

        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        left.left = leftLeft;
        left.right = leftRight;

        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;

        ZPrintTree zPrintTree = new ZPrintTree();
        zPrintTree.Print(root);
    }


    /**
     * 就是层次遍历 复杂度较高
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        queue.offer(null);
        ArrayList<Integer> tempList = new ArrayList<>();
        result.add(tempList);
        boolean flag = true;
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode != null){
                tempList.add(treeNode.val);
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }else {
                if(!queue.isEmpty()){
                    if(!flag){
                        Collections.reverse(tempList);
                    }
                    tempList = new ArrayList<>();
                    result.add(tempList);
                    queue.offer(null);
                    flag = flag ? false : true;
                }else {
                    if(!flag){
                        Collections.reverse(tempList);
                    }
                }
            }
        }
//        result.forEach((list)->{
//            list.forEach(one-> System.out.println(one));
//        });
        return result;
    }

    /*public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res_list = new ArrayList<>();
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while(!s1.empty() || !s2.empty()){
            if(layer%2 != 0){
                ArrayList<Integer> list = new ArrayList<>();
                while(!s1.empty()){
                    TreeNode t = s1.pop();
                    if(t != null){
                        list.add(t.val);
                        s2.push(t.left);
                        s2.push(t.right);
                    }
                }
                if (!list.isEmpty()) {
                    res_list.add(list);
                    layer++;
                }
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                while(!s2.empty()){
                    TreeNode t = s2.pop();
                    if(t != null){
                        list.add(t.val);
                        s1.push(t.right);
                        s1.push(t.left);
                    }
                }
                if (!list.isEmpty()) {
                    res_list.add(list);
                    layer++;
                }
            }
        }
        return res_list;
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
