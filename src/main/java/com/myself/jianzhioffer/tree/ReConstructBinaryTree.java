package com.myself.jianzhioffer.tree;

import java.util.Arrays;

/**
 * @program: ReConstructBinaryTree
 * @description: 二叉树回溯
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: qll
 * @create: 2020-01-03 14:36
 **/
public class ReConstructBinaryTree {
    public static void main(String[] args) {
        ReConstructBinaryTree t = new ReConstructBinaryTree();
        TreeNode treeNode = t.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        System.out.println(treeNode);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 1){
            return new TreeNode(pre[0]);
        }
        if(pre.length == 0){
            return null;
        }
        //根据前序遍历得到根节点,第一个节点就是根节点
        TreeNode root = new TreeNode(pre[0]);
        /**
         * 根据中序遍历得到左右子树
         * 1、得到根节点位置
         * 2、得到左右子树 前序、中序数组
         */
        Integer pos = getPos(pre[0], in);
        //前序左子树
        int [] bLtree = Arrays.copyOfRange(pre,1,pos+1);
        //前序右子树
        int [] bRtree = Arrays.copyOfRange(pre,pos+1,pre.length);
        //中序左子树
        int [] mLtree = Arrays.copyOfRange(in,0,pos);
        //中序右子树
        int [] mRtree = Arrays.copyOfRange(in,pos+1,in.length);
        root.left = reConstructBinaryTree(bLtree,mLtree);
        root.right = reConstructBinaryTree(bRtree,mRtree);

        return root;
    }

    public Integer getPos(int val,int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val){
                return i;
            }
        }
        return 0;
    }




static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


}
