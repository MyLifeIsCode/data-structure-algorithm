package com.myself.tree.towthree;

import lombok.Data;

/**
 * @program: Tree23
 * @description: 2-3树
 * 2-3树定义
 *
 * 一颗2-3树或为一颗空树，或有以下节点组成：
 * 2-节点，含有一个元素和两个子树（左右子树），左子树所有元素的值均小于它父节点，右子树所有元素的值均大于它父节点；
 * 3-节点，还有两个元素和三个子树（左中右子树），左子树所有元素的值均小于它父节点，中子树所有元素的值都位于父节点两个元素之间，右子树所有元素的值均大于它父节点。
 * @author: qll
 * @create: 2020-01-02 10:29
 * 参考
 * https://mp.weixin.qq.com/s/kZo58Lq7rxjqO5M3c-fPRA
 *  https://kswapd.cn/article/twothreetree-and-rbtree/
 **/
@Data
public class TwoThreeTree {

    private TTNode root;
    public static void main(String[] args) {
        TwoThreeTree twoThreeTree = new TwoThreeTree();
        twoThreeTree.put(1);
        twoThreeTree.put(2);
        twoThreeTree.put(3);
        twoThreeTree.put(4);
        twoThreeTree.put(5);
        twoThreeTree.put(6);
        twoThreeTree.put(7);
        System.out.println(twoThreeTree.getRoot());
    }

    /**
     * 添加新数据
     * @param key
     * @return
     */
    public Boolean put(Integer key){
        if(root == null){
            root = new TTNode();
            root.getKeys().add(key);
            return true;
        }
        TTNode insertNode = findInsertNode(root, key);
        if(insertNode != null){
            insertNode.insert(key);
        }
        if(insertNode.needSplit()){
            split(insertNode);
        }
        return true;
    }

    public TTNode findInsertNode(TTNode start,Integer key){
        if(start == null){
            return null;
        }
        if(start.getKeys().contains(key)){
            return null;
        }
        if(start.isLeaf()){
            return start;
        }
        int keyCount = start.getKeys().size();
        if(key < start.getKeys().get(0)){
            //左
            return findInsertNode(start.getChildren().get(0),key);
        }else if(key > start.getKeys().get(keyCount - 1)){
            //右
            return findInsertNode(start.getChildren().get(keyCount),key);
        }else {
            //中
            return findInsertNode(start.getChildren().get(1),key);
        }
    }

    /**
     * 分裂
     * @param node
     */
    public void split(TTNode node){
        if(node == null)
            return;
        //获取中间节点的值
        Integer middle = node.getKeys().get(1);
        //当前节点父节点
        TTNode parent = node.getParent();
        // 新分裂的节点
        TTNode newNode = new TTNode();
        //此时是叶子节点分裂，初始分裂状态一定是根节点
        if(node.isLeaf()){
            //将右节点值放入新节点
            newNode.getKeys().add(node.getKeys().get(2));
            //移除右节点和中节点,先移除大的下标
            node.getKeys().remove(2);
            node.getKeys().remove(1);
        }else {
            //分裂节点不是叶子节点，也就是向一个父节点为2-节点的3-节点中插入元素 所导致的
            //node的最后两个children节点给newNode最为children,注意顺序
            newNode.getChildren().add(node.getChildren().get(2));
            newNode.getChildren().add(node.getChildren().get(3));
            //父节点一处上边两个孩子
            node.getChildren().remove(3);
            node.getChildren().remove(2);
            //新节点newNode的key值为node的最大值key
            newNode.getKeys().add(node.getKeys().get(2));
            //node移除最大的key值
            node.getKeys().remove(2);
            //删除node的中键，因为中键会上移
            node.getKeys().remove(1);
        }
        if(parent == null){
            root = new TTNode();
            root.setParent(null);
            root.getKeys().add(middle);
            root.getChildren().add(node);
            root.getChildren().add(newNode);
            node.setParent(root);
            newNode.setParent(root);
        }else {
            //把当前分裂出来的newNode插入到父节点的孩子节点中
            int indexInParent = parent.getChildren().indexOf(node);
            parent.getChildren().add(indexInParent+1,newNode);
            //将中节点放入父节点中
            parent.getKeys().add(middle);
            //将新节点newNode的父节点指向当前parent
            newNode.setParent(parent);
            if (parent.needSplit()) {
                split(parent);
            }
        }
    }
}
