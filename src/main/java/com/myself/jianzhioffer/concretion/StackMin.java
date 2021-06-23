package com.myself.jianzhioffer.concretion;
import java.util.Stack;

/**
 * @program: StackMin
 * @description: 查找栈中最小元素
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author: qll
 * @create: 2020-01-15 11:23
 **/
public class StackMin {
    /*借用辅助栈存储min的大小，自定义了栈结构
     */
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);
        }
    }

    public void pop() {
        Integer top = top();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return minStack.peek();
    }
    public int min() {
        return min;
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        int[] arr = {9,3,5,7,2,4,6,8};
        for (int i = 0; i < arr.length; i++) {
            stackMin.push(arr[i]);
        }
        System.out.println(stackMin.min());
    }
}
