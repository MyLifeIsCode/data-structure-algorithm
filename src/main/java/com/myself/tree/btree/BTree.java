package com.myself.tree.btree;

/**
 * @program: jubian-cloud->BTree
 * @description:Btree
 * （1）每个结点最多有m-1个关键字。
 * （2）根结点最少可以只有1个关键字。
 * （3）非根结点至少有Math.ceil(m/2)-1个关键字。Math.ceil(m/2)含义是向上取整。例如Math.ceil(4.5) = 5。
 * （4）每个结点中的关键字都按照从小到大的顺序排列，每个关键字的左子树中的所有关键字都小于它，而右子树中的所有关键字都大于它。
 * （5）所有叶子结点都位于同一层，或者说根结点到每个叶子结点的长度都相同。
 *
 * B树的插入流程如下：
 *   （1）根据要插入的key的值，对B树执行查找操作，查找到待插入数据的当前节点位置。
 *   （2）判断当前结点key的个数是否小于等于m-1，若满足，则结束直接插入数据，否则，进行第（3）步。
 *   （3）以结点中间的key为中心分裂成左右两部分，然后将这个中间的key插入到父结点中，这个key的左子树指向分裂后的左半部分，这个key的右子支指向分裂后的右半部分，然后将当前结点指向父结点，继续进行第（3）步。
 *B树的删除流程如下：
 *   （1）如果当前需要删除的key位于非叶子结点上，则用后继key（这里的后继key均指后继记录的意思）覆盖要删除的key，然后在后继key所在的子支中删除该后继key。此时后继key一定位于叶子结点上，这个过程和二叉搜索树删除结点的方式类似。删除这个记录后执行第2步
 *   （2）该结点key个数大于等于Math.ceil(m/2)-1，结束删除操作，否则执行第（3）步。
 *   （3）如果兄弟结点key个数大于Math.ceil(m/2)-1，则父结点中的key下移到该结点，兄弟结点中的一个key上移，删除操作结束。否则，将父结点中的key下移与当前结点及它的兄弟结点中的key合并，形成一个新的结点。原父结点中的key的两个孩子指针就变成了一个孩子指针，指向这个新结点。然后当前结点的指针指向父结点，重复第（2）步。
 *
 *  @author: qll
 * @create: 2020-01-02 16:41
 *
 * 参考
 * //结构
 * https://www.cxyxiaowu.com/901.html
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653190965&idx=1&sn=53f78fa037386f85531832cd5322d2a0&chksm=8c9909efbbee80f90512f0c36356c31cc74c388c46388dc2317d43c8f8597298f233ca9c29e9&scene=21#wechat_redirect
 * //代码
 * https://github.com/lazy-apple/BTree
 * https://github.com/tclxspy/Articles
 **/
public class BTree {
}
