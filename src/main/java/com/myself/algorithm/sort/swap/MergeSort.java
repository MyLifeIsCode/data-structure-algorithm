package com.myself.algorithm.sort.swap;

import java.util.Arrays;

/**
 * 归并排序
 * 先拆后合，首先将数组拆分成小数组，左边小右边大，之后合并
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,2,4,6,8};
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int left,int right,int[] temp){
        if(right <= left){
            return;
        }
        int mod = (left + right)/2;
        sort(arr,left,mod,temp);
        sort(arr,mod+1,right,temp);
        merge(arr,temp,left,right,mod);
    }
    public static void merge(int[] arr,int[] temp,int left,int right ,int mod){
        int i = left;
        int j = mod + 1;
        int t = 0;
        while (i <= mod && j <= right){
            if(arr[i] >= arr[j]){
                temp[t++] = arr[j++];
            }else {
                temp[t++] = arr[i++];
            }
        }
        //左边赋值
        while (i <= mod){
            temp[t++] = arr[i++];
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp赋值给arr
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }
}
