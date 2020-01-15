package com.myself.jianzhioffer.other;

import java.util.ArrayList;

/**
 * @program: jubian-cloud->PrintMatrix
 * @description: 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: qll
 * @create: 2020-01-15 10:14
 **/
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int sum = row * col;
        int i=0,j=0;//行，类
        while (sum > 0){
            //从左到右
            for (int k = 0;sum>0 && k <col;sum --,k++){
                list.add(matrix[i][j]);
                j++;
            }
            row --;
            i++;
            j--;
            //从上到下
            for (int k = 0; sum>0 && k < row;sum--,k++){
                list.add(matrix[i][j]);
                i++;
            }
            col --;
            j --;
            i--;
            //从右到左
            for (int k = 0;sum>0 && k < col;sum--,k++){
                list.add(matrix[i][j]);
                j--;
            }
            row --;
            i --;
            j++;
            //从下向上
            for (int k = 0;sum > 0 && k < row;sum--,k++){
                list.add(matrix[i][j]);
                i--;
            }
            col --;
            j++;
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        PrintMatrix p = new PrintMatrix();
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        p.printMatrix(arr);
    }
}
