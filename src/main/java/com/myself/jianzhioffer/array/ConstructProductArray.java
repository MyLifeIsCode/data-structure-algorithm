package com.myself.jianzhioffer.array;

/**
 * @program: ConstructProductArray
 * @description: 构造乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * B0   1   A1  A2  A3  ... An
 * B1   A0  1   A2  A3  ... An
 * B2   A0  A1  1   A3  ... An
 * ...              1   ... An
 * BN   A0  A1      ...     1
 * @author: qll
 * @create: 2020-01-08 10:08
 **/
public class ConstructProductArray {
    public int[] multiply(int[] A) {
        if(A == null){
            return null;
        }
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        //计算下三角
        for (int i = 1; i < length; i++) {
            B[i] = A[i-1] * B[i-1];
        }
        //计算上三角，这个temp相当与B[0]
        int temp = 1;
        //这里B[n-1]就不用再次计算了，所以j = length - 2
        for (int j = length - 2; j >=0 ; j--) {
            temp = temp * A[j+1];
            B[j] = B[j] * temp;
        }
        return B;
    }

}
