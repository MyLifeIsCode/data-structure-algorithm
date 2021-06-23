package com.myself.letcode;

import java.util.Arrays;

/**
 * @program: Fraction
 * @description: 分式拆分
 * @author: qll
 * @create: 2019-11-29 10:36
 **/
public class Fraction {
    public static void main(String[] args) {
        int[] cont = {3, 2, 0, 2};
        System.out.println(Arrays.toString(fraction(cont)));
    }

    public static int[] fraction(int[] cont) {
        int[] ans = {1,1};
        int len = cont.length;
        if (len == 0) return ans;
        ans[1] = cont[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            int tmp = ans[1];
            ans[1] = cont[i] * ans[1] + ans[0];
            ans[0] = tmp;
        };
        ans[0] = ans[0] ^ ans[1];
        ans[1] = ans[0] ^ ans[1];
        ans[0] = ans[0] ^ ans[1];
        return ans;
    }
}
