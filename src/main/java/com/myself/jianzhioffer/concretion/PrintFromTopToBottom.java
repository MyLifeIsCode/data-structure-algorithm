package com.myself.jianzhioffer.concretion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: jubian-cloud->PrintFromTopToBottom
 * @description: 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author: qll
 * @create: 2020-01-15 14:05
 **/
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                result.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return result;
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
