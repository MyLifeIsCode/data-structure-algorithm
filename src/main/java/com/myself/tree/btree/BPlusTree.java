package com.myself.tree.btree;

/**
 * @program: BPlusTree
 * @description: b+树
 * B+树的特征：
 * 1.有k个子树的中间节点包含有k个元素（B树中是k-1个元素），每个元素不保存数据，只用来索引，所有数据都保存在叶子节点。
 * 2.所有的叶子结点中包含了全部元素的信息，及指向含这些元素记录的指针，且叶子结点本身依关键字的大小自小而大顺序链接。
 * 3.所有的中间节点元素都同时存在于子节点，在子节点元素中是最大（或最小）元素。
 *
 * B+树的优势：
 * 1.单一节点存储更多的元素，使得查询的IO次数更少。
 * 2.所有查询都要查找到叶子节点，查询性能稳定。
 * 3.所有叶子节点形成有序链表，便于范围查询。
 *
 * 需要补充的是，在数据库的聚集索引（Clustered Index）中，叶子节点直接包含卫星数据。在非聚集索引（NonClustered Index）中，叶子节点带有指向卫星数据的指针。

 * @author: qll
 * @create: 2020-01-02 17:36
 **/
public class BPlusTree {
}
