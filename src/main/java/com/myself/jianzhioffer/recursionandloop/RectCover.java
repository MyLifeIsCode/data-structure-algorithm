package com.myself.jianzhioffer.recursionandloop;

/**
 * @program: jubian-cloud->RectCover
 * @description: 摆砖块
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 链接：https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6?f=discussion
 * 来源：牛客网
 *
 * 分析：
 * (1) n等于1时，总共有1种方法。
 *
 * (2) n等于2时，总共有2种方法。
 * 2*1的矩形，横着或竖着分别一种。
 *
 * (3) n等于3时，总共有3种方法。
 * 1) 2*1的矩形全部竖着放;  2)第一列 2*1的矩形竖着放，后面两列横着放两个2*1的矩形; 3)前面两行横着放两个2*1的矩形，最后一列竖着放一个2*1的矩形。
 *
 * .............................
 * 我们可以看到，由于2*1的小矩形可以横着放也可以竖着放，当n=3的时候，在n=2的基础上其实只有一种放法了，就是把第三个2*1的小矩形竖着放，在n=1的基础上，把第二个和第三个2*1的小矩形横着放（有人会说为什么竖着放两个不算，这已经包括在n=2的情况下了）。所以抽象表示就是f(3)=f(2)+f(1)。也还是裴波那契的思想。不过如果递归复杂度比较高，因此我们还是用“跳台阶”的方法来实现。
 * @author: qll
 * @create: 2020-01-13 15:55
 **/
public class RectCover {
    public int RectCover(int target) {

        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

}
