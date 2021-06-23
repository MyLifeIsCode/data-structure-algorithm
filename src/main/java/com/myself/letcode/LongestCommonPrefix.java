package com.myself.letcode;

/**
 * @program: LongestCommonPrefix
 * @description: 最长前缀
 * @author: qll
 * @create: 2019-11-28 11:44
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flo","flow","fl","flower"}));
    }

    //水平扫描发
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++)
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        return prefix;
//    }

    //分治法
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String s = longestCommonPrefix(strs, 0, strs.length - 1);
        return s;
    }

    public static String longestCommonPrefix(String[] strs,int start,int end){
        if(start == end){
            return strs[start];
        }else {
            int mod = (start + end)/2;
            String leftStr = longestCommonPrefix(strs, start, mod);
            String rightStr = longestCommonPrefix(strs,mod + 1,end);
            return compireProfix(leftStr,rightStr);
        }
    }

    public static String compireProfix(String start,String end){
        int min = Math.min(start.length(), end.length());
        for (int i = 0; i < min; i++) {
            if(start.charAt(i) != end.charAt(i)){
                return start.substring(0,i);
            }
        }
        return start.substring(0,min);
    }
}
