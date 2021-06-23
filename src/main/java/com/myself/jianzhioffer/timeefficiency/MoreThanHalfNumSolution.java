package com.myself.jianzhioffer.timeefficiency;

/**
 * @program: MoreThanHalfNumSolution
 * @description: 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author: qll
 * @create: 2020-01-16 16:08
 * 链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?f=discussion
 * 来源：牛客网
 * 思路一：数组排序后，如果符合条件的数存在，则一定是数组中间那个数。（比如：1，2，2，2，3；或2，2，2，3，4；或2，3，4，4，4等等）
 * 这种方法虽然容易理解，但由于涉及到快排sort，其时间复杂度为O(NlogN)并非最优；
 **/
public class MoreThanHalfNumSolution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) return 0;
        if(array.length == 1) return array[0];

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if(times == 0){
                result = array[i];
                times = 1;
            }else {
                if(result == array[i]){
                    times ++;
                }else {
                    times --;
                }
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if(result == array[i]){
                times ++;
            }
        }
        if(times > array.length/2){
            return result;
        }else {
            return 0;
        }
    }

}
