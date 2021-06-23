package com.myself.jianzhioffer.codecomplete;

/**
 * @program: FindKthToTail
 * @description: 链表倒数第k个数
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author: qll
 * @create: 2020-01-14 14:11
 **/
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) { //5,{1,2,3,4,5}
        ListNode p=head,q=head;
        int i = 0;
        while (p != null){
            if(i >= k){
                q = q.next;
            }
            p = p.next;
            i++;
        }
        return k > i ? null : q;
    }

    public static void main(String[] args) {
        FindKthToTail f = new FindKthToTail();
//        1,2,3,4,5
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = f.FindKthToTail(root, 1);
        System.out.println(listNode.val);
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
