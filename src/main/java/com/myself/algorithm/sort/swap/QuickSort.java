package com.myself.algorithm.sort.swap;

import java.util.Arrays;

/**
 * 快速排序
 *思路：选择一个基准值，比这个值大的数再右边，比这个数小的再左边，基准值一般选择第一个数
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {5,6,5,4,1,-10};
        quickSort_pointer(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //挖坑法
    private static void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex > endIndex){
            return;
        }
        int standard = arr[startIndex];
        int i = startIndex;
        int j = endIndex;

        while (endIndex > startIndex){
            //比较右边
            while (startIndex < endIndex){
                if(arr[endIndex] < standard){
                    arr[startIndex] = arr[endIndex];
                    startIndex ++;
                    break;
                }else {
                    endIndex --;
                }
            }
            //比较右边的
            while (startIndex < endIndex ){
                if(arr[startIndex] > standard){
                    arr[endIndex] = arr[startIndex];
                    endIndex --;
                    break;
                }else {
                    startIndex ++;
                }
            }
        }
        if(startIndex == endIndex){
            arr[startIndex] = standard;
        }
        quickSort(arr,i,startIndex-1);
        quickSort(arr,startIndex+1,j);

    }

    //指针替换法
    public static void quickSort_pointer(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int low = left;
        int high = right;
        int provider = arr[left];
        while (left < right){
            while (left < right && arr[left] < provider){
                left ++;
            }
            while (left < right && arr[right] >= provider){
                right --;
            }
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //指针重合处和基准值替换
        arr[left] = provider;

        //循环左边
        quickSort(arr,low,left-1);
        //循环右边
        quickSort(arr,left+1,high);
    }

}
