package com.myself.letcode;

/**
 * @program: MinTimeToVisitAllPoints
 * @description: 最小距离
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 * @author: qll
 * @create: 2019-11-30 16:01
 **/
public class MinTimeToVisitAllPoints {

    public static void main(String[] args) {

    }
    public static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += Math.max(Math.abs(points[i][0] - points[i+1][0]),Math.abs(points[i][1] - points[i+1][1]));
        }
        return sum;
    }
}
