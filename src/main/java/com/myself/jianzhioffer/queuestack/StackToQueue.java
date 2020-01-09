package com.myself.jianzhioffer.queuestack;

import java.util.Stack;

/**
 * @program: jubian-cloud->StackToQueue
 * @description: 用2个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: qll
 * @create: 2020-01-09 16:58
 **/
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());
        stackToQueue.push(4);
        stackToQueue.push(5);
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());

    }
    public void push(int node) {
        if(stack1.isEmpty() && stack2.isEmpty()){
            stack1.push(node);
        }else if(stack2.empty()){
            stack1.push(node);
        }else {
            stack2.push(node);
        }
    }

    public int pop() {
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        Integer first = null;
        if(!stack1.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            first = stack2.pop();
        }
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return first;
    }
}
