package com.myself.jianzhioffer.analysisQuestion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: jubian-cloud->StringPermutation
 * @description: 字符串排列组合
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @author: qll
 * @create: 2020-01-16 14:10
 **/
public class StringPermutation {

    /**
     * https://www.jianshu.com/p/e0de4c9b73f2
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.isEmpty()){
            return list;
        }
        char[] chars = str.toCharArray();
        PermutationHelp(chars,0,chars.length-1,list);
        Collections.sort(list);
        return list;
    }

    public void PermutationHelp(char[] chars,int start,int end,ArrayList<String> list){
        if(end == chars.length - 1){
            String s = String.valueOf(chars);
            if(!list.contains(s)){
                list.add(s);
            }
        }
        for (int j = start; j <= end; j++) {
            swap(chars,start,j);
            PermutationHelp(chars,start+1,end,list);
            swap(chars,start,j);
        }
    }
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}

























