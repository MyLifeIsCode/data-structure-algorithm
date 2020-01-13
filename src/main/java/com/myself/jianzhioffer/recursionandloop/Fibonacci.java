package com.myself.jianzhioffer.recursionandloop;

/**
 * @program: jubian-cloud->Fabnaci
 * @description: 斐波那契数列
 * @author: qll
 * @create: 2020-01-13 14:33
 **/
public class Fibonacci {
    //递归
//    public int Fibonacci(int n) {
//        if(n == 0){
//            return 0;
//        }
//        if(n == 1 || n == 2){
//            return 1;
//        }
//        return Fibonacci(n-1) + Fibonacci(n-2);
//    }

    //循环方式
    public int Fibonacci(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int fibonacci = f.Fibonacci(3);
        System.out.println(fibonacci);
    }
}
