package com.myself.jianzhioffer.tree;

import javafx.scene.control.TableRow;

/**
 * @program: jubian-cloud->TreeNextNode
 * @description: 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * url: https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author: qll
 * @create: 2020-01-03 15:40
 **/
public class TreeNextNode {

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);

        //右节点
//        TreeLinkNode right1 = new TreeLinkNode(2);
//        root.right = right1;

        //右节点有左子节点
//        right1.left = new TreeLinkNode(4);

        //父节点
        root.next = new TreeLinkNode(9);

        TreeNextNode t = new TreeNextNode();
        TreeLinkNode treeLinkNode = t.GetNext(root);
        System.out.println(treeLinkNode.val);
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        /**
         * 分为3中情况
         * 1、该节点有右子树，且右子树有左子树，则一直找左子树，知道某一个左子树没有左子树则返回
         * 2、该节点有右子树，且右子树没有左子树，则返回右子树
         * 3、该节点没有右子树， 1、回溯父节点 ，该节点节点父节点不是任何节点的的左子树，则返回null, 2、回溯过程中找到了某个节点子节点是该节点父节点，则返回该父节点
         */
        if(pNode.right != null ){
            if(pNode.right.left == null){
                return pNode.right;
            }else {
                TreeLinkNode leftNode = pNode.right.left;
                while (leftNode != null && leftNode.left != null){
                    leftNode = leftNode.left;
                }
                return leftNode;
            }
        }else {
            TreeLinkNode parentNode = pNode.next;
            TreeLinkNode thisNode = pNode;
            while (parentNode != null){
                if(parentNode.left == thisNode){
                    return parentNode;
                }else {
                    thisNode = parentNode;
                    parentNode = parentNode.next;
                }
            }
            return null;
        }
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; //这个next就是parent，原题如此

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
