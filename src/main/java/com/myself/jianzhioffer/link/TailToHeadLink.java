package com.myself.jianzhioffer.link;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: jubian-cloud->TailToHeadLink
 * @description: 从尾部到头部打印链表
 * @author: qll
 * @create: 2020-01-09 14:23
 **/
public class TailToHeadLink {
    public static void main(String[] args) {
        TailToHeadLink tailToHeadLink = new TailToHeadLink();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        tailToHeadLink.EntryNodeOfLoop(listNode);
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode != null){
            stack.push(listNode.val);
        }else {
            return list;
        }
        ListNode next = listNode.next;

        while (next != null){
            stack.push(next.val);
            next = next.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    //递归方式

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //找环
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        while(p2!=null&&p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
            {
                p1=pHead;
                while(p1!=p2)
                {
                    p1=p1.next;
                    p2=p2.next;
                }
                if(p1==p2)return p1;
            }
        }
        return null;
    }

}
