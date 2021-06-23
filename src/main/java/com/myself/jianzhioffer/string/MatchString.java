package com.myself.jianzhioffer.string;

/**
 * @program: MatchString
 * @description: 字符串匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author: qll
 * @create: 2020-01-09 10:02
 **/
public class MatchString {
    public static void main(String[] args) {
        MatchString matchString = new MatchString();
        char[] a = new char[]{};
        char[] b = new char[]{'.','*'};

        boolean match = matchString.match(a, b);
        System.out.println(match);
    }
    public boolean match(char[] str, char[] pattern)
    {
        return matchTwo(str,0,str.length,pattern,0,pattern.length);

    }
    private boolean matchTwo(char[] str, int i, int length1, char[] pattern,
                             int j, int length2) {
        if(i==length1&&j==length2) {
            return true;
        }
        if(i==length1&&j!=length2) {
            while(j!=length2){
                if(pattern[j]!='*'&&(j+1>=length2||pattern[j+1]!='*')){
                    return false;
                }
                j++;
            }
            return true;
        }
        if(i!=length1&&j==length2) {
            return false;
        }
        if(j+1==length2){
            if(str[i]==pattern[j]||pattern[j]=='.')
                return matchTwo(str, i+1, length1, pattern, j+1, length2);
            else {
                return false;
            }
        }
        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]!='*')
            return matchTwo(str, i+1, length1, pattern, j+1, length2);
        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]=='*')
            return matchTwo(str, i, length1, pattern, j+2, length2)||matchTwo(str, i+1, length1, pattern, j, length2);
        if(pattern[j+1]=='*')
            return matchTwo(str, i, length1, pattern, j+2, length2);
        return false;
    }
/* //不对

    public boolean match(char[] str, char[] pattern){
        if(str.length == 0 && pattern.length == 0){
            return true;
        }
        if(new String(pattern).equals(".*")){
            return true;
        }
        //前一个字符串
        int strIndex = 0;
        char prePattern = pattern[0];
        //1、如果前一个字符为空
        for (int j = 0; j < pattern.length; j++) {
            if(strIndex >= str.length){
                return false;
            }
            char curPattern = pattern[j];
            //匹配 .
            if(curPattern == '.'){
                strIndex ++;
            }else if(curPattern == '*'){
                if(prePattern == '.'){
                    continue;
                }else if(str[strIndex] == prePattern){
                    strIndex ++;
                    continue;
                }else {
                    return false;
                }
            }else if(str[strIndex] != pattern[j]){
                return false;
            }else {
                strIndex ++;
            }
            prePattern = curPattern;
        }
        return true;
    }
*/

}
