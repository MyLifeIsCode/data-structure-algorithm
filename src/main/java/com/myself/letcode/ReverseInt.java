package com.myself.letcode;

/**
 * @program: jubian-cloud->ReverseInt
 * @description: 整数反转
 * 解题思路
 * 方式1 取模运算
     * 1、取模 x/10,x /= 10,             rev = rev * 10 + pop;
     * 2、判断是否益处 如果是整数 pop不能大于临界值7 ，如果是负数pop不能小于临界值-8
     * 临界值index = Integer.MAX_VALUE % 10
     * @author: qll
     * @create: 2019-11-27 16:49
 *方式2 字符串数组
 * 1、将整数转为字符串数组
 * 2、按位转化为Long * 10^i
 * 3、是否比Integer最大值大或者最小值小
 **/
public class ReverseInt {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if(rev  > Integer.MAX_VALUE/10 || (rev * 10 == Integer.MAX_VALUE/10 &&  pop > 7)) return 0;
            if(rev  < Integer.MIN_VALUE/10 || (rev * 10 == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static Integer reverseByStr(int x){
        String s = Integer.toString(x);
        char c = s.charAt(0);
        int f = 1;
        if(c == '-'){
            f = -1;
            s = s.substring(1);
        }
        char[] chars = s.toCharArray();
        char[] reverse = new char[s.length()];
        for (int i=chars.length - 1;i>=0;i--) {
            reverse[chars.length - i -1] = chars[i];
        }
        long l = Long.parseLong(new String(reverse)) * f;
        if(l > Integer.MAX_VALUE || l < Integer.MIN_VALUE){
            return 0;
        }
        return (int)l;
    }

    public static void main(String[] args) {
//        int reverse = reverse(2147483611);
        Integer reverse = reverseByStr(-123);
        System.out.println(reverse);

    }

}
