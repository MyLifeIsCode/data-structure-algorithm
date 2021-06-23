package com.myself.letcode;

/**
 * @program: Palindrome
 * @description: 判断是否为回文数
 * 1、取后半段
 * 2、字符串方式
 * 3、前后比对
 * @author: qll
 * @create: 2019-11-27 17:57
 **/
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    public static boolean isPalindrome(int x){
        if (x < 0 || (x % 10 == 0 && x > 9))  return false;
        int rev = 0;

        while (rev < x){
            int pop = x % 10;
            rev = rev *10 + pop;
            x /= 10;
        }
        return  rev == x  || rev/10 == x;
    }
}
