package com.myself.tree.binary.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: TreeNode
 * @description: 线性二叉树
 * @author: qll
 * @create: 2019-12-27 11:13
 **/
public class BinaryArrayTree {


    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,2,4,6,8};
        before(0,arr);


    }

    /**
     * 前序遍历
     * @param index
     * @param arr
     * @return
     */
    public static void before(int index, int[] arr){
        System.out.println(arr[index]);
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        //遍历左边
        if(left <= arr.length-1){
            before(left,arr);
        }
        //遍历右边
        if(right <= arr.length-1){
            before(right,arr);
        }
    }


    /**
     * 中序遍历
     * @param index
     * @param arr
     */
    public static void midel(int index,int[] arr){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        //遍历左边
        if(left <= arr.length-1){
            midel(left,arr);
        }
        System.out.println(arr[index]);
        //遍历右边
        if(right <= arr.length-1){
            midel(right,arr);
        }
    }

    /**
     * 后序遍历
     * @param index
     * @param arr
     */
    public static void after(int index,int[] arr){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        //遍历左边
        if(left <= arr.length-1){
            after(left,arr);
        }
        //遍历右边
        if(right <= arr.length-1){
            after(right,arr);
        }
        System.out.println(arr[index]);

    }
    static Queue<Integer> queue=new LinkedList<Integer>();
    static List<List<Integer>> rsList = new ArrayList<>();

    /**
     * 用空行作为
     * @param index
     * @param arr
     */
    public static void levelorder(int index,int[] arr){
        //添加根
        queue.offer(arr[index]);
        queue.offer(null);
        List<Integer> tempList = new ArrayList<>();
        rsList.add(tempList);
        int num = 0;
        while (!queue.isEmpty()){
            Integer temp = queue.poll();
            if(temp != null){
                tempList.add(temp);
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                if(left < arr.length){
                    queue.offer(arr[left]);
                }
                if(right < arr.length){
                    queue.offer(arr[right]);
                }
            }else {
                if(!queue.isEmpty()){
                    num ++;
                    tempList = new ArrayList<>();
                    queue.offer(null);
                    rsList.add(tempList);
                }
            }
            index ++;
        }
        for (int i = 0; i < rsList.size(); i++) {
            List<Integer> integers = rsList.get(i);
            for (int i1 = 0; i1 < integers.size(); i1++) {
                System.out.printf(integers.get(i1) + ",");
            }
            System.out.println("--------------------");
        }
    }



}
























