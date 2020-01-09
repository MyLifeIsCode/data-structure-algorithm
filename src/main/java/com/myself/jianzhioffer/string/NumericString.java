package com.myself.jianzhioffer.string;

import java.util.Arrays;

/**
 * @program: jubian-cloud->NumericString
 * @description: 数字字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author: qll
 * @create: 2020-01-09 11:11
 **/
public class NumericString {
    public static void main(String[] args) {
        NumericString numericString = new NumericString();
        boolean numeric = numericString.isNumeric(new char[]{'1', '2', '3', '.', '4', '5', 'e', '+', '6'});
        System.out.println(numeric);
    }

    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
    /*//参见剑指offer
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }*/
}
