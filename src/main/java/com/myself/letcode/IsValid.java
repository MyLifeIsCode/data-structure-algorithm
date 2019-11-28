package com.myself.letcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @program: jubian-cloud->IsValid
 * @description: 有效的括号
 * 使用数据结构栈
 * @author: qll
 * @create: 2019-11-28 14:51
 **/
public class IsValid {

    static Map<Character,Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public static void main(String[] args) {
        System.out.println(isValid("["));
    }
    public static boolean isValid(String s) {
        //初始化栈
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Objects.nonNull(map.get(chars[i]))){
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(pop == map.get(chars[i])){
                    continue;
                }
                else {
                    return false;
                }
            }else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
