package com.myself.jianzhioffer.concretion;

/**
 * @program: jubian-cloud->VerifySquenceOfBST
 * @description: 判断是否为后续遍历
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author: qll
 * @create: 2020-01-15 14:41
 **/
public class VerifySquenceOfBST {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd?f=discussion
     * 来源：牛客网
     *
     * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
     * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，
     * 前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return judge(sequence,0,sequence.length - 1);
    }

    public boolean judge(int[] arr,int start,int end){
        if(start >= end) return  true;
        int i = end;
        while (i>start && arr[i] >= arr[end]) i--;
        for (int j = i-1;j>=start;--j){
            if(arr[j] >= arr[end]){
                return false;
            }
        }
        return judge(arr,start,i - 1) && judge(arr,i,end-1);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST v = new VerifySquenceOfBST();
        int[] arr = {5,4,3,2,1};
        boolean b = v.VerifySquenceOfBST(arr);
        System.out.println(b);
    }
}
