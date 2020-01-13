package com.myself.jianzhioffer.queuestack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @program: jubian-cloud->MaxInWindows
 * @description: 滑动窗口的最大值
 * @author: qll
 * @create: 2020-01-09 17:41
 **/
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new ArrayDeque<>(3);
        int max = 0;
        for (int i = 0; i < size; i++) {
            if(num[i] > max){
                max = num[i];
            }
            queue.offer(num[i]);
        }
        list.add(max);
        for (int i = size-1;i<num.length-1;i++){
            queue.offer(num[i]);
            list.add(max);
        }
        return list;
    }

    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length-size; i++) {
            int[] arr = Arrays.copyOfRange(num,i,size+ i);
            int[] ints = quickSort(arr, 0, arr.length - 1);
            list.add(ints[size-1]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,2,6,2,5,1};
        MaxInWindows maxInWindows = new MaxInWindows();
//        maxInWindows.bubbleSort(arr);
//        int[] ints = maxInWindows.quickSort(arr, 0, arr.length - 1);
//        System.out.println(ints);
//
//        int[] ints1 = maxInWindows.selectSort(arr);
//        System.out.println(ints1);
//
//        int[] ints2 = maxInWindows.insertSort(arr);
//        System.out.println(ints2);
//
//        int[] ints3 = maxInWindows.hellSort(arr);
//        System.out.println(ints3);

//        int[] ints4 = maxInWindows.mergeSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//        int[] ints5 = maxInWindows.heapSort(arr);
//        System.out.println(Arrays.toString(ints5));
        ArrayList<Integer> list = maxInWindows.maxInWindows(arr, 3);
        System.out.println(Arrays.toString(list.toArray()));
    }
    //冒泡排序
    public int bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i+1;j<arr.length;j++){
                if(arr[index] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[index];
                    arr[index] = temp;
                }else {
                    index = j;
                }
            }
        }
        return arr[arr.length-1];
    }
    //快速排序
    public int[] quickSort(int[] arr,int left,int right){
        if(left >= right){
            return arr;
        }
        int standard = arr[left];
        int start = left;
        int end = right;
        while (start < end){
            while (start < end){
                if(arr[end] < standard){
                    arr[start] = arr[end];
                    start ++;
                    break;
                }else {
                    end --;
                }
            }
            while (start < end){
                if(arr[start] > standard){
                    arr[end] = arr[start];
                    end --;
                    break;
                }else {
                    start ++;
                }
            }
        }
        arr[start] = standard;
        quickSort(arr,left,start);
        quickSort(arr,start + 1,right);
        return arr;
    }

    //选择排序
    public int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    //插入排序
    public int[] insertSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int insertIndex = i;
            for (int j = i;j>=0;j--){
                if(arr[j] < arr[i]){
                    insertIndex = j;
                }else {
                    break;
                }
            }
            if(insertIndex != i){
                int insertVal = arr[i];
                for (int tempIndex = i;tempIndex > insertIndex;tempIndex --){
                    arr[tempIndex] = arr[tempIndex - 1];
                }
                arr[insertIndex] = insertVal;
            }
        }
        return arr;
    }
    //希尔排序
    public int[] hellSort(int[] arr){
        int d = arr.length;
        while (d > 1){
            d = d/2;
            hillInsertSort(arr,d);
        }
        return arr;
    }
    public void hillInsertSort(int[] arr,int d){
        for (int i = 0; i < arr.length; i+=d) {
            int insertIndex = i;
            for (int j = i;j>=0;j-=d){
                if(arr[j] < arr[i]){
                    insertIndex = j;
                }else {
                    break;
                }
            }
            if(insertIndex != i){
                int insertVal = arr[i];
                for (int tempIndex = i;tempIndex > insertIndex;tempIndex -=d){
                    arr[tempIndex] = arr[tempIndex - d];
                }
                arr[insertIndex] = insertVal;
            }
        }
    }

    //归并排序
    public int[] mergeSort(int[] arr,int left,int right){
        if(left >= right){
            return arr;
        }
        int mod = (left + right) / 2;
        mergeSort(arr,left,mod);
        mergeSort(arr,mod + 1,right);
        merge(arr,left,mod,right);
        return arr;
    }

    public void merge(int[] arr,int left,int mod,int right){
        int[] temp = new int[arr.length];
        int t = 0;
        int i = left;
        int j = mod + 1;
        while (i <= mod && j <= right){
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                i++;
            }else {
                temp[t] = arr[j];
                j++;
            }
            t ++;
        }
        if(i >= left){
            for (;j<=right;j++){
                temp[t] = arr[j];
            }
        }else if(j >= right){
            for (;i<=left;i++){
                t++;
                temp[t] = arr[i];
            }
        }
        t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }

    public void swap(int[] arr,int from,int to){
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    //堆排序
    public int[] heapSort(int[] arr){
        int mod = arr.length / 2;
        for (int i = mod; i >= 0; i--) {
            buildMaxHeap(arr,i,arr.length-1);
        }
        for (int i = arr.length - 1; i >=0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildMaxHeap(arr,0,i-1);
        }
        return arr;
    }
    //构建大根堆
    public void buildMaxHeap(int[] arr,int parent,int length){
        int child = 2 * parent + 1;
        while (child <= length){
            int max = parent;
            if(arr[child] > arr[parent]){
                max = child;
            }
            child ++;
            if(child <= length && arr[child] > arr[max]){
                max = child;
            }
            if(max != parent){
                int temp = arr[parent];
                arr[parent] = arr[max];
                arr[max] = temp;
            }
            parent ++;
            child = 2 * parent + 1;
        }
    }

}
