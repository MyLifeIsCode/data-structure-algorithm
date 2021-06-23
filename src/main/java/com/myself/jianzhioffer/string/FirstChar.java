package com.myself.jianzhioffer.string;

/**
 * @program: FirstChar
 * @description: 第一个出现一次的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author: qll
 * @create: 2020-01-09 13:55
 **/
public class FirstChar {
    public static void main(String[] args) {
        FirstChar firstChar = new FirstChar();
        char[] chars = "google".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            firstChar.Insert(chars[i]);
        }
        char c = firstChar.FirstAppearingOnce();
        System.out.println(c);
    }
    //Insert one char from stringstream
    int[] chars = new int[256];
    int index = 1;
    public void Insert(char ch)
    {
        if(chars[ch] == 0){
            //出现第一次
            chars[ch] = index++;
        }else {
            //出现多次
            chars[ch] = -1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        char ch = '#';
        int minxIndex = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 1 && minxIndex > chars[i]){
                ch = (char) i;
                minxIndex = chars[i];
            }
        }
        return ch;
    }

}
