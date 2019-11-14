package com.myself.algorithm;

/**
 * 斐波那契数列 1 1 2 3 5 8 13 21
 */
public class Fibonacci {

    public static void main(String[] args) {
        int fibonacci = fibonacci(10);
        System.out.println(fibonacci);
    }
    private static int fibonacci(int i){
        if(i == 1 || i == 2){
            return 1;
        }else {
            return fibonacci(i-1) + fibonacci(i-2);
        }
    }
}
