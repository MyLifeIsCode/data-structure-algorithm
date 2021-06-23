package com.myself.jianzhioffer.recursionandloop;

/**
 * @program: JumpFloor
 * @description: 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 斐波那契数列思想
 * @author: qll
 * @create: 2020-01-13 15:03
 **/
public class JumpFloor {
//    public int JumpFloor(int target) {
//        if(target <= 0){
//            return 0;
//        }
//        if(target == 1){
//            return 1;
//        }
//        if(target == 2){
//            return 2;
//        }
//        return JumpFloor(target - 1) + JumpFloor(target - 2);
//    }

    public int JumpFloor(int target) {
        int preNum = 1;
        int prePreNum = 0;
        int result = 0;
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        for (int i = 1; i <= target; i++) {
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }

    public static void main(String[] args) {
        JumpFloor j = new JumpFloor();
        int i = j.JumpFloor(3);
        System.out.println(i);
    }
}
