package com.myself.jianzhioffer.binary;

/**
 * @program: NumberOf1
 * @description: 整数中二进制1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author: qll
 * @create: 2020-01-13 16:10
 **/
public class NumberOf1 {
    public int NumberOf1(int n) {
        int  count = 0;
        while (n != 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 numberOf = new NumberOf1();
        int i = numberOf.NumberOf1(5);
        System.out.println(i);
    }
}
