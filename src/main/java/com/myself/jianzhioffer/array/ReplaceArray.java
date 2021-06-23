package com.myself.jianzhioffer.array;

/**
 * @program: ReplaceArray
 * @description: 替换字符
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: qll
 * @create: 2020-01-07 17:05
 **/
public class ReplaceArray {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString().replaceAll(" ", "%20");
        return s;
    }

    public static void main(String[] args) {
    }
}
