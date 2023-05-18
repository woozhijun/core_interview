package com.woozhijun.interview.algo.dynamic;

/**
 * 爬楼梯 - 动态规划
 * @Author: wuzhijun
 * @Date: 2020/10/18 23:16
 */
public class ClimbStairs {

    public static int fromType(int n) {
        int step1 = 1;
        int step2 = 2;
        int temp = 0;
        if (n <= 2) {
            return n;
        } else {
            for (int i = 2; i < n; i++) {
                temp = step1 + step2;
                step1 = step2;
                step2 = temp;
            }
            return temp;
        }
    }

    /**
     * 动态规划 构建 f(x)=f(x−1)+f(x−2)
     * @param n
     * @return
     */
    public static int fromType2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 10; i ++) {
            System.out.println(fromType(i));
        }
    }
}