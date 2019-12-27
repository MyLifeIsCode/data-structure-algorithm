package com.myself.algorithm.sort.swap;

import java.util.Arrays;

/**
 * @program: data-structure-algorithm->HeapSort
 * @description: 堆排序,构建大顶堆（小顶堆），之后排序
 * @author: qll
 * @create: 2019-11-14 19:24
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,2,4,6,10};
        int start = arr.length/2 ;
//        for (int i=start;i>=0;i--){
//            buildMinHeap(arr,i,arr.length);
//        }
//        System.out.println(Arrays.toString(arr));
//
//        int[] arr2 = {1,3,5,7,9,2,4,6,10};
        for (int i=start;i>=0;i--){
            buildMaxHeap(arr,i,arr.length);
        }
//        System.out.println(Arrays.toString(arr));
//        buildMaxHeap(arr,start,arr.length);
        for (int i = arr.length - 1;i>0;i--){
            //第一个位置和最后一个位置
            if(arr[0] >= arr[i]){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
            }
            System.out.println(Arrays.toString(arr));
            buildMaxHeap(arr,0,i-1);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    //构建小顶堆
    public static void buildMinHeap(int[] arr,int parentIndex,int length){
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length){
            //如果父节点比子节点小，则进行交换
            if(childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex] ){
                childIndex ++;
            }
            if(temp < arr[childIndex]){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex +1;
        }
        arr[parentIndex] = temp;
    }

    //构建大顶堆
    public static void buildMaxHeap(int[] arr,int parentIndex,int length){
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length){
            //如果父节点比子节点小，则进行交换
            if(childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex] ){
                childIndex ++;
            }
            if(temp > arr[childIndex]){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex +1;
        }
        arr[parentIndex] = temp;
    }

}
























