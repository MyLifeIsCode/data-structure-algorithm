package com.myself.jianzhioffer.tree;

/**
 * @program: jubian-cloud->TreeSerDeser
 * @description: 序列化反序列化
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * @author: qll
 * @create: 2020-01-06 11:08
 *
 **/
public class TreeSerDeser {

    private int index = -1;
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
        TreeSerDeser treeSerDeser = new TreeSerDeser();
        String s = treeSerDeser.Serialize(root);
        TreeNode deserialize = treeSerDeser.Deserialize(s);
    }
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return "#";
        }
        sb.append(root.val + "");
        return Serialize(root,sb);
    }
    String Serialize(TreeNode root, StringBuilder sb){
        sb.append(","+ (null == root.left ? "#" : root.left.val+""));
        if(root.left != null){
            Serialize(root.left,sb);
        }
        sb.append(","+ (null == root.right ? "#" : root.right.val+""));
        if(root.right != null){
            Serialize(root.right,sb);
        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index ++;

        String[] strings = str.split(",");
        if(index > strings.length){
            return null;
        }
        TreeNode treeNode = null;
        if(!"#".equals(strings[index])){
            treeNode = new TreeNode(Integer.parseInt(strings[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
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
