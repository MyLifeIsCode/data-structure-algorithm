package com.myself.tree.binary;

import lombok.Data;

/**
 * @program: jubian-cloud->TreeNode
 * @description:
 * @author: qll
 * @create: 2019-12-27 15:27
 **/
@Data
public class TreeNode {

    private Integer value;
    private TreeNode leftNode;
    private TreeNode rightNode;


    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lHeight = height(root.leftNode);
        int rHeight = height(root.rightNode);
        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;

    }
}
