package com.myself.algorithm;

/**
 * 汉诺塔问题
 */
public class Hanoi {

    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }

    /**
     *
     * @param n 一给你个几个
     * @param from 开始位置
     * @param in 中间位置
     * @param to 结束位置
     * @return
     */
    private static void hanoi(int n,char from,char in,char to){
        if(n == 1){
            System.out.println("第一个盘子从from:"+from + "移动到to:"+ to);
        }else {
            //把上边n-1个盘子移动到in
            hanoi(n-1,from,to,in);
            System.out.println("第"+n+"个盘子从from:"+from + "移动到to:"+ to);
            //把in中间位置所有盘子移动到to
            hanoi(n-1,in,from,to);
        }
    }
}
