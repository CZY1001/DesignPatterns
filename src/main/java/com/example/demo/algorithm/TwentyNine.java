package com.example.demo.algorithm;

/**
 * @author czy
 * @summary 两数相除
 * @date 2023-12-25 11:14
 *
 * 不用乘法除法，取余等操作
 *
我们这里可以考虑使用【倍增乘法】来实现，所谓倍增乘法，简单理解就是每次用被除数减去[除数的最大的2x2^x2x]，这样可以极大地增加处理的速度
比如，假定被除数为 20，除数为 3

当然，上述的描述过程我们使用了乘法，实际我们却不能使用乘法，所以，我们可以使用加法来处理
 */
public class TwentyNine {
    public static int MAX = Integer.MAX_VALUE;
    public static int MIN = Integer.MIN_VALUE;

    public  int test(int beichushu, int chushu) {
        //校验溢出情况
        if (beichushu == MAX && chushu == MIN) {
            return MAX;
        }
        //记录结果的符号
        int sign = -1;
        //如果除数和被除数 符号一样，那就是正的，如果不一样，那就是负的
        if ((beichushu > 0 && chushu > 0) || (beichushu < 0 && chushu < 0)) {
            sign = 1;
        }
        //全都转换成负数，防止溢出
        beichushu = beichushu > 0 ? -beichushu : beichushu;
        chushu = chushu > 0 ? -chushu : chushu;
        int ans = 0;
        //假设 被除数是20  除数是3   那么就是  -20   -3
        // 倍乘法，注意都是负数了，比较的时候与正数相反
        // 简单点理解，就是每次减去除数的 2^x 倍数，剩下的部分继续按这样的规则继续
        while (beichushu <= chushu) {
            int tmp = chushu;
            //记录累加几次
            int count = 1;
            // 这里注意不要写成 tmp + tmp >= beichushu，这样写加法有可能会溢出导致死循环
            while (tmp >= beichushu - tmp) {
                tmp += tmp;
                count += count;
            }
            //当做下次的结果
            beichushu -= tmp;
            //这里的ans 记录每次的累加值   相当于2的2次方+2的1次方
            ans += count;
        }
        return sign < 0 ? -ans : ans;
    }
}
