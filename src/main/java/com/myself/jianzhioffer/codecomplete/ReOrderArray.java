package com.myself.jianzhioffer.codecomplete;

import java.util.Arrays;

/**
 * @program: ReOrderArray
 * @description: 奇数偶数排序
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 链接：https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593?f=discussion
 * 来源：牛客网
 * 相对位置不变--->保持稳定性；奇数位于前面，偶数位于后面 --->存在判断，挪动元素位置；
 * 这些都和内部排序算法相似，考虑到具有稳定性的排序算法不多，例如插入排序，归并排序等；这里采用插入排序的思想实现。
 * @author: qll
 * @create: 2020-01-14 11:13
 **/
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int even = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] %2 == 1){//如果是偶数，将所有奇数向前移动
                int j = i;
                int temp = array[j];
                int count = 0;
                while (count < even && j > 0){
                    array[j] = array[--j];
                    count ++;
                }
                array[j] = temp;
            }else {
                even ++;
            }
        }
    }

    public static void main(String[] args) {
        ReOrderArray reOrderArray = new ReOrderArray();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        reOrderArray.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));

    }
}
