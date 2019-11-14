package com.myself.algorithm.sort.swap;

import java.util.Arrays;

/**
 * 选择排序，每次选一个数最为基准坐标值，和其后边每个数进行比较，如果比后边值大则基准坐标置为该值所在位置坐标，直到比较
 * 至最后一个属，结束比较，将初始化最小位置值与当前位置的值互换
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,2,4,6,8,10};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        for (int i =0;i<arr.length;i++){
            int minIndex = i;
            for (int j=i+i;j<arr.length;j++){
                if(arr[j] < arr[i]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
