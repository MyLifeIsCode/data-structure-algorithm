package com.myself.algorithm.sort.swap;

import java.util.Arrays;

/**
 * 插入排序,假设插入数据前边都是有序的，用插入数据和前边的比较，如果比前边的小则进行替换
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,22,511,3};
//        insertSort(arr);
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void insertSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            int insertIndex = i;
            for (int j=i;j>=0;j--){
                if(arr[j] > arr[insertIndex]){
                    int temp = arr[insertIndex];
                    arr[insertIndex] = arr[j];
                    arr[j] = temp;
                    insertIndex = j;
                }
            }
        }
    }

    private static void insertSort2(int arr[]){
        for (int i=0;i<arr.length;i++){
            int insertIndex = arr[i];
            int j=i-1;
            for (;j>=0&&arr[j] > insertIndex;j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = insertIndex;
        }
    }
}
