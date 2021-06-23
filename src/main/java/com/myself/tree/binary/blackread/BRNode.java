package com.myself.tree.binary.blackread;

import lombok.Data;

/**
 * @program: BRNode
 * @description: 红黑树节点
 * @author: qll
 * @create: 2019-12-31 11:17
 **/
@Data
public class BRNode {

    private boolean color;//true 红，false，黑

    private BRNode rightNode;

    private BRNode leftNode;

    private BRNode parent;

    private Integer value;

    @Override
    public String toString() {
        return "BRNode{" +
                "color=" + color +
                ", value=" + value +
                '}';
    }
}
