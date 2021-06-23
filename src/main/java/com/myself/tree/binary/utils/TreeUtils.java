package com.myself.tree.binary.utils;

import com.myself.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: TreeUtils
 * @description:
 * @author: qll
 * @create: 2019-12-27 15:28
 **/
public class TreeUtils {

    /**
     * 构建二叉树
     * @param index
     * @param arr
     * @return
     */
    public static TreeNode arrayToTree(int index,int[] arr){
        List<TreeNode> list = new ArrayList<>();
        TreeNode treeNode = new TreeNode();
        treeNode.setValue(arr[index]);
        list.add(treeNode);
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = list.get(i);
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if(left < arr.length){
                TreeNode leftNode = new TreeNode();
                leftNode.setValue(arr[left]);
                node.setLeftNode(leftNode);
                list.add(leftNode);
            }else {
                list.add(null);
            }
            if(right < arr.length){
                TreeNode rightNode = new TreeNode();
                rightNode.setValue(arr[right]);
                node.setRightNode(rightNode);
                list.add(rightNode);
            }else {
                list.add(null);
            }
        }
        return treeNode;
    }


}
