package com.myself.letcode;

/**
 * @program: RemoveDuplicates
 * @description: 删除数组中重复值
 * 方法：双指针法
 * @author: qll
 * @create: 2019-11-28 20:08
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {

    }
    private static int removeDuplicates(int[] nums){
        if(nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                nums[i + 1] = nums[j];
                i ++;
            }
        }
        return i;
    }
}
