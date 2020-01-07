package com.myself.jianzhioffer.array;

/**
 * @program: jubian-cloud->TwoArraySearch
 * @description: 二维数组查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: qll
 * @create: 2020-01-07 13:32
 **/
public class TwoArraySearch {
    public boolean Find(int target, int [][] array) {
        int col = array[0].length - 1;//类数量
        int row = 0;
        while (row < array.length && col >=0){
            if(array[row][col] == target){
                return true;
            }else if(array[row][col]<target){
                row ++;
            }else{
                col --;
            }
        }
        return false;
    }
}
