package com.myself.jianzhioffer.analysisQuestion;

import java.util.Stack;

/**
 * @program: jubian-cloud->TreeConvertLink
 * @description: 树转链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author: qll
 * @create: 2020-01-16 11:00
 **/
public class TreeConvertLink {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?f=discussion
     * 来源：牛客网
     *
     * 方法二：递归版
     * 解题思路：
     * 1.将左子树构造成双链表，并返回链表头节点。
     * 2.定位至左子树双链表最后一个节点。
     * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     * 4.将右子树构造成双链表，并返回链表头节点。
     * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     * 6.根据左子树链表是否为空确定返回的节点。
     * @param root
     * @return
     */
    public TreeNode Convert(TreeNode root) {
        if(root == null) return  null;
        if(root.left == null && root.right == null) return root;
        //将左子树转为链表
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        while (p != null && p.right != null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        //将右子树转为链表
        TreeNode right = Convert(root.right);
        if(right != null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

    //循环方式
    public TreeNode Convert2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        boolean isFirst = true;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(isFirst){
                root = cur;
                isFirst = false;
                pre = root;
            }else {
                cur.left = pre;
                pre.right = cur;
                pre = cur;
            }
            cur = cur.right;
        }
        return root;
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
