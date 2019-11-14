package com.myself.algorithm.sort.swap;

import java.util.Arrays;

/**
 * 希尔排序
 * 根据不同的递增步值进行分组，每次步值都是上一次的一一半，每次排序时使用插入排序
 */
public class HillSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,2,4,6,8,10};
        hillSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void hillSort(int[] arr){
        int d = arr.length;
        while (d > 1){
            d = d/2;
            insertSort(arr,d);
        }
    }

    public static void insertSort(int[] arr,int d){
        for (int i=arr.length-1;i>=1;i --){
            int insertValue = arr[i];
            int j = i;
            for (;j-d>=0;j-=d){
                if(arr[j-d] > arr[j]){
                    arr[j] = arr[j-d];
                }else {
                    break;
                }
            }
            arr[j] = insertValue;
        }
    }
}
