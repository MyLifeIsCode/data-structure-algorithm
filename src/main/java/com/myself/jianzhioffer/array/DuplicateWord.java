package com.myself.jianzhioffer.array;

/**
 * @program: DuplicateWord
 * @description: 重复key
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 * @author: qll
 * @create: 2020-01-07 17:29
 **/
public class DuplicateWord {
    public static void main(String[] args) {
        duplicate(new int[]{1,2,3,4,5},5,new int[5]);
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(null == numbers){
            return false;
        }
        boolean[] num = new boolean[length+1];
        for (int i = 0; i < numbers.length; i++) {
            if(num[numbers[i]] == true){
                duplication[0] = numbers[i];
                return true;
            }
            num[numbers[i]] = true;
        }
        return false;
    }
}
