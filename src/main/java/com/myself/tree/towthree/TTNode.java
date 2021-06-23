package com.myself.tree.towthree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Node23
 * @description: 2-3树节点
 * @author: qll
 * @create: 2020-01-02 10:28
 **/

@Data
public class TTNode {

    private TTNode parent = null;


    private List<Integer> keys = new ArrayList<>();

    private List<TTNode> children = new ArrayList<>();

    /**
     * 插入值
     * @param value
     */
    public void insert(Integer value){
        keys.add(value);
        Collections.sort(keys);
    }

    /**
     * 是否为叶子节点
     * @return
     */
    public boolean isLeaf(){
        return this.getChildren().isEmpty();
    }
    /**
     * 需要分裂
     *
     * @return true/false
     */
    public boolean needSplit() {
        return keys.size() > 2;
    }

    @Override
    public String toString() {
        return "Node{" +
                "keys=" + keys +
                '}';
    }
}

























