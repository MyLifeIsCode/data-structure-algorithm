package com.myself.tree.binary.blackread;

import com.myself.linker.Node;
import com.myself.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: BRTree
 * @description: 红黑树
 * 1、如果插入节点的父节点和叔节点都是红色 变色->左旋转->右旋转
 * 2、如果插入节点的父节点红色，叔节点是 黑色，且插入节点是右节点，则进行左旋转
 * 3、如果插入节点父节点是红色，叔节点是黑色，且插入节点是左节点，则进行右旋转
 * @author: qll
 * @create: 2019-12-31 11:22
 **/
public class BRTree {

    private BRNode root;

    public static void main(String[] args) {
        BRTree brTree = new BRTree();
        int[] arr = {10,5,15,4,6,11,16};
        for (int i = 0; i < arr.length; i++) {
            BRNode node = new BRNode();
            node.setColor(true);
            node.setValue(arr[i]);
            brTree.insert(node);
        }

        brTree.levelOrder(brTree.root);
    }

    /**
     * 左旋转
     * 左旋示意图：对节点x进行左旋

     *     p                       p

     *    /                       /

     *   x                       y

     *  / \                     / \

     * lx  y      ----->       x  ry

     *    / \                 / \

     *   ly ry               lx ly

     * 左旋做了三件事：

     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)

     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)

     * 3. 将y的左子节点设为x，将x的父节点设为y
     * @param node
     * @return 新节点
     */
    private BRNode leftRotate(BRNode node){
        BRNode newNode = node.getRightNode();
        //将newNode的左子树赋值为node的右子树
        node.setRightNode(newNode.getLeftNode());
        //将node的父节点赋值给newNode
        newNode.setParent(node.getParent());
        //如果node为根节点，则将newNode赋值为根节点
        if(node.getParent() == null){
            this.root = newNode;
        }else {
            //更新node父节点
            if(node == node.getParent().getLeftNode()){
                //如果是左子节点，则将newNode赋值为node父节点的左子树
                node.getParent().setLeftNode(newNode);
            }else {
                node.getParent().setRightNode(newNode);
            }
        }
        //将node设置为newNode的左子树
        newNode.setLeftNode(node);
        //将newNode的父节点设置为node的父节点
        newNode.setParent(node.getParent());
        return newNode;
    }

    private BRNode rightRotate(BRNode node){
        //1、新节点为当前节点的左子树
        BRNode newNode = node.getLeftNode();
        //2、将node节点的左子树设置为newNode的右子树
        node.setLeftNode(newNode.getRightNode());
        //3、如果node节点父节点位空，则将newNode设置为根节点
        if(node.getParent() == null){
            this.root = newNode;
        }else {
            //更新node的父节点
            if(node.getParent().getLeftNode() == null){
                node.getParent().setLeftNode(newNode);
            }else {
                node.getParent().setRightNode(newNode);
            }
        }
        //4、将node的父节点设置为newNode
        node.setParent(newNode);
        //5、将node设置为new的右子树
        newNode.setRightNode(node);
        return newNode;
    }

    /**
     * 插入
     * @param node
     */
    public void insert(BRNode node){
        BRNode x = this.root;
        //插入节点的父节点
        BRNode parent = null;
        //得到要插入节点的父节点
        while (x != null){
            parent = x;
            int comp = x.getValue().compareTo(node.getValue());
            if(comp >= 1){
                //左
                x = x.getLeftNode();
            }else {
                x = x.getRightNode();
            }
        }
        node.setParent(parent);
        //判断插入节点是左节点还是右节点
        if(parent != null){
            int comp = parent.getValue().compareTo(node.getValue());
            if(comp < 0){
                parent.setRightNode(node);
            }else {
                parent.setLeftNode(node);
            }
        }else {
            this.root = node;
        }
        //3. 将它重新修整为一颗红黑树
        insertFixUp(node);
    }

    /**
     * 1、判断是否需要变色
     *      变色：1、将当前节点的父节、叔节点变为黑色；将祖父节点变为红色
     *             2、将当前节点指向其祖父节点
     *             3、continue
     *      左旋转：1、以当前节点为支点，进行左旋转
     *              2、continue
     *      右旋转：1、将当前节点父节点涂黑，将其祖父节点涂红，以其祖父节点为支点进行右旋转
     *              2、continue
     * @param node
     */
    private void insertFixUp(BRNode node) {
        BRNode parent,gparent;//父节点、祖父节点
        while ((parent = node.getParent()) != null && isRead(parent)){
            gparent = parent.getParent();
            //判断是否需要变色
            //左节点
            if(parent == gparent.getLeftNode()){
                //获得叔叔节点
                BRNode uncle = gparent.getRightNode();
                //叔节点是红色
               if(uncle != null && isRead(uncle)){
                   parent.setColor(false);
                   uncle.setColor(false);
                   gparent.setColor(true);
                   node = gparent;
                   continue;
               }
                //叔节点为黑色，插入节点是左子节点，进行右旋转
               if(node == parent.getRightNode()){
                   leftRotate(node);
                   BRNode temp = parent;
                   parent = node;
                   node = temp;
               }
                //叔节点是黑色，插入今典是右节点，进行左旋转
                parent.setColor(false);
                gparent.setColor(true);
                rightRotate(gparent);
            }else {
                //右节点，与左节点取反
                //获得叔叔节点
                BRNode uncle = gparent.getLeftNode();
                //叔节点是红色
                if(uncle != null && isRead(uncle)){
                    parent.setColor(false);
                    uncle.setColor(false);
                    gparent.setColor(true);
                    node = gparent;
                    continue;
                }
                //叔节点为黑丝，插入节点是左子节点，进行右旋转
                if(node == parent.getLeftNode()){
                    rightRotate(node);
                    BRNode temp = parent;
                    parent = node;
                    node = temp;
                }
                //叔节点是黑色，插入今典是右节点，进行左旋转
                parent.setColor(false);
                gparent.setColor(true);
                leftRotate(gparent);
            }
        }
        //将根节点赋值为黑色
        this.root.setColor(false);
    }

    static Queue<BRNode> queue = new LinkedList<>();
    static List<List<BRNode>> resList = new ArrayList<>();
    public void levelOrder(BRNode node){
        queue.offer(node);
        queue.offer(null);
        List<BRNode> tempList = new ArrayList<>();
        resList.add(tempList);
        while (!queue.isEmpty()){
            BRNode poll = queue.poll();
            if(poll != null){
                tempList.add(poll);
                if(poll.getLeftNode()!= null){
                    queue.offer(poll.getLeftNode());
                }
                if(poll.getRightNode() != null){
                    queue.offer(poll.getRightNode());
                }
            }else {
                if(!queue.isEmpty()){
                    tempList = new ArrayList<>();
                    resList.add(tempList);
                    queue.offer(null);
                }

            }
        }
        for (List<BRNode> treeNodes : resList) {
            for (BRNode treeNode : treeNodes) {
                System.out.print(treeNode.getValue() + "-" + treeNode.isColor());
            }
            System.out.println();
            System.out.println("---------------------------------------");
        }
    }

    private boolean isRead(BRNode node){
        return node.isColor();
    }

}
