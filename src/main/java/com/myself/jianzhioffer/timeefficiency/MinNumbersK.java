package com.myself.jianzhioffer.timeefficiency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: MinNumbersK
 * @description: 最小k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: qll
 * @create: 2020-01-16 16:18
 **/
public class MinNumbersK {
    public static void main(String[] args) {
        MinNumbersK minNumbersK = new MinNumbersK();
        int[] arr = {4,5,1,6,2,7,3,8};

//        minNumbersK.quickSort(arr,0,arr.length-1);
//        minNumbersK.selectSort(arr,0,arr.length-1);
//        minNumbersK.bubbleSort(arr);
//        minNumbersK.insertSort(arr,1);
//        minNumbersK.hellSort(arr);
//        int[] temp = new int[arr.length];
//        minNumbersK.mergeSort(arr,0,arr.length-1,temp);
        minNumbersK.heapSort(arr);
        System.out.println(Arrays.toString(arr));
//        ArrayList<Integer> list = minNumbersK.GetLeastNumbers_Solution(arr, 4);
//        System.out.println(list);

    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input == null || input.length == 0 || input.length<k) return list;
        quickSort(input,0,input.length-1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public void quickSort(int[] array,int start,int end){
        if(start >= end) return;
        int standard = array[start];//基准值
        int left = start,right = end;
        while (left < right){
            while (left < right){
                if(array[right] < standard){
                    array[left] = array[right];
                    left ++;
                    break;
                }else {
                    right --;
                }
            }
            while (left<right ){
                if(array[left] > standard){
                    array[right] = array[left];
                    right --;
                    break;
                }else {
                    left ++;
                }
            }
        }
        array[left] = standard;
        quickSort(array,start,left);
        quickSort(array,left+1,end);
    }

    public void selectSort(int[] array,int start,int end){
        if(start >= end) return;
        int minIndex = start;
        for (int i = start+1; i <= end; i++) {
            if(array[minIndex] > array[i]){
                minIndex = i;
            }
        }
        if(minIndex != start){
            int temp = array[minIndex];
            array[minIndex] = array[start];
            array[start] = temp;
        }
        selectSort(array,start+1,end);
    }

    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void insertSort(int[] arr,int d){
        if(arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i+=d) {
            int insertIndex = i;
            for (int j = i-1; j >=0; j-=d) {
                if(arr[insertIndex] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[insertIndex];
                    arr[insertIndex] = temp;
                    insertIndex = j;
                }
            }
        }
    }

    public void hellSort(int[] arr){
        int d = arr.length/2;
        while (d>=1){
            insertSort(arr,d);
            d = d / 2;
        }
    }

    public int[] mergeSort(int[] arr,int start,int end,int[] temp){
        if(start >= end) return temp;
        int mod = (start + end) / 2;
        mergeSort(arr,start,mod,temp);
        mergeSort(arr,mod+1,end,temp);
        merge(arr,start,end,mod,temp);
        return temp;
    }
    public void merge(int[] arr,int left,int right,int mod,int[] temp){
        if(left >= right) return;
        int min = left;
        int max = mod+1;
        int t = 0;
        while (min <= mod && max <= right){
            if(arr[min] < arr[max]){
                temp[t++] = arr[min++];
            }else {
                temp[t++] = arr[max++];
            }
        }
        while (min <= mod){
            temp[t++] = arr[min++];
        }
        while (max <= right){
            temp[t++] = arr[max++];
        }
    }

    public void heapSort(int[] arr){
        int mod = arr.length / 2;
        for (int i = mod; i >= 0; i--) {
            buildMaxHeap(arr,i,arr.length-1);
        }
        for (int k = arr.length -1;k>=0;k--){
            swap(arr,0,k);
            buildMaxHeap(arr,mod,k-1);
        }
    }
    public void buildMaxHeap(int[] arr,int parent,int length){
        while (parent >= 0){
            int child = 2 * parent + 1;
            if(child <= length){
                if(arr[child] > arr[parent]){
                    swap(arr,parent,child);
                }
            }
            child ++;
            if(child <= length){
                if(arr[child] > arr[parent]){
                    swap(arr,parent,child);
                }
            }
            parent --;
        }
    }
    public void swap(int[] arr,int from,int to){
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}












