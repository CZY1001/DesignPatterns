package com.example.demo.algorithm;

/**
 28. 找出字符串中第一个匹配项的下标
 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 如果 needle 不是 haystack 的一部分，则返回  -1 。

 */
public class TwentyEight {
    /*
    枚举原串 ss 中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配
     */
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty()||needle.isEmpty()){
            return -1;
        }
        //直接循环暴力解
        int n = haystack.length();
        int m = needle.length();
        //遍历长字符串的下标
        for (int i = 0;i+m<=n;i++){
            boolean bool = true;
            //遍历看当前长字符串的下标起始是否匹配短字符串
            for (int j = 0; j<m;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    bool = false;
                    break;
                }
            }
            //如果成功匹配了，直接返回
            if (bool){
                return i;
            }
        }
        return -1;
    }

    /**
     * kmp解法
     * @param haystack 原字符串
     * @param needle 子字符串
     * @return 返回首个匹配成功的下标
     */
    public int strStrKMP(String haystack, String needle) {
        //获取子串的部分匹配值
        int[] next = kmpNext(needle);
        for (int i = 0,j=0;i<haystack.length();i++){
            //需要考虑当haystack.charAt(i)==needle.charAt(j)不相等的时候
            //需要去进行回溯
            while (j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j = next[j-1];
            }
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if (j==needle.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 获取一个字符串的部分匹配值表
     * @param str 目标字符串
     * @return 匹配值表
     */
    public int[] kmpNext(String str){
        //创建一个数组，保存部分匹配值的
        int [] next = new int[str.length()];
        //第一位的匹配值永远都是0
        next[0] = 0;
        //匹配值
        int j = 0;
        //遍历目标字符串
        for (int i = 1; i<str.length();i++){
            //ABCDABD  [0,0,0,0,1,2,0]
            //当str.charAt(i) != str.charAt(j) 的时候，需要去匹配值数组获取他前面的那个匹配值；
            //直到我们找到有 str.charAt(i) == str.charAt(j) 或者j到0的时候才结束掉 ，相当于往前的一个回溯
            //核心点
            while (j >0 && str.charAt(i) != str.charAt(j)){
                j = next[j-1];
            }
            //如果满足 str.charAt(i) == str.charAt(j) 匹配值就+1
            if (str.charAt(i) == str.charAt(j)){
                j++;
            }
            //给当前位置的匹配值记录上
            next[i] = j;
        }
        return next;
    }
}
