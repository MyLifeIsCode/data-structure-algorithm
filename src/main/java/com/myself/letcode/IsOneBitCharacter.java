package com.myself.letcode;

/**
 * @program: IsOneBitCharacter
 * @description: 结尾是否为1比特
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *解法
 * 方法二：贪心
 * 三种字符分别为 0，10 和 11，那么 \mathrm{bits}bits 数组中出现的所有 0 都表示一个字符的结束位置（无论其为一比特还是两比特）。因此最后一位是否为一比特字符，只和他左侧出现的连续的 1 的个数（即它与倒数第二个 0 出现的位置之间的 1 的个数，如果 \mathrm{bits}bits 数组中只有 1 个 0，那么就是整个数组的长度减一）有关。如果 1 的个数为偶数个，那么最后一位是一比特字符，如果 1 的个数为奇数个，那么最后一位不是一比特字符。
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/solution/1bi-te-yu-2bi-te-zi-fu-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: qll
 * @create: 2019-11-30 16:14
 **/
public class IsOneBitCharacter {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1,1,1,1,1,1,1,0}));
    }

    public static boolean isOneBitCharacter(int[] bits){
        int i = bits.length -2;
        while ( i >= 0 && bits[i] > 0) i--;
        return (bits.length - i ) % 2 == 0;
    }
}
