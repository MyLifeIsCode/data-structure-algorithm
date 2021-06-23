package com.myself.jianzhioffer.codecomplete;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: ListMerge
 * @description: 链表合并
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author: qll
 * @create: 2020-01-14 15:36
 **/
public class ListMerge {
    //递归
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        while (list1 != null && list2 != null){
            if(list2 == null)
                break;
            if(list1.val > list2.val){
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
            if(list1 == null){
                while (list2 != null){
                    temp.next = list2;
                    list2 = list2.next;
                    temp = temp.next;
                }
            }else if(list2 == null){
                while (list1 != null){
                    temp.next=list1;
                    list1 = list1.next;
                    temp = temp.next;
                }
            }
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListMerge l = new ListMerge();
        // {1,3,5},{2,4,6}
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        root.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode root2 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node32 = new ListNode(6);
//        ListNode node42 = new ListNode(6);
//        ListNode node52 = new ListNode(7);
        root2.next = node22;
        node22.next = node32;
//        node32.next = node42;
//        node42.next = node52;
        ListNode listNode = l.Merge(root,root2);
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
