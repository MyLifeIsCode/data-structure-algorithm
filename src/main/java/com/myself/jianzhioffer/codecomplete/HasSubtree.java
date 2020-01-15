package com.myself.jianzhioffer.codecomplete;

/**
 * @program: jubian-cloud->HasSubtree
 * @description: 判断两棵树是否是父子树
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author: qll
 * @create: 2020-01-14 16:33
 **/
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        return isSUbTree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean isSUbTree(TreeNode root1,TreeNode root2){
        if (root2 == null) return true;
        if (root1 == null) return false;

        if(root1.val == root2.val){
            return isSUbTree(root1.left,root2.left) && isSUbTree(root1.right,root2.right);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
//        {8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
//        {8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
        TreeNode root1 = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode root2 = new TreeNode(8);
        TreeNode node_1 = new TreeNode(9);
        TreeNode node_2 = new TreeNode(2);
        root2.left = node_1;
        root2.right = node_2;

        HasSubtree h = new HasSubtree();
        boolean b = h.HasSubtree(root1, root2);
        System.out.println(b);

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
