package com.woozhijun.data.structure.sort;

/**
 * @Author: wuzhijun
 * @Date: 2020/10/30 01:35
 */
public class QuickSort {

    public static void quick(int[] num, int left, int right) {
        int i = left;
        int j = right;
        if (left > right) {
            return;
        }
        int mark = num[left];
        while (i != j) {
            while (num[j] >= mark && i < j) {
                j--;
            }
            while (num[i] <= mark && i < j) {
                i++;
            }
            int tmp = 0;
            if (i < j) {
                tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
            }
        }
        num[left] = num[i];
        num[i] = mark;
        quick(num, left, i - 1);
        quick(num,i + 1, right);
    }
}
