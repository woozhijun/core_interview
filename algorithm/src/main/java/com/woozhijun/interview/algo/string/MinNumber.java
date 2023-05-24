package com.woozhijun.interview.algo.string;

import java.util.Arrays;

/**
 * @author zhijunwoo
 * @create by 2023/5/24 15:13
 * @Desc 把数组排成最小的数
 */
public class MinNumber {

    /**
     * 重写排序
     * x + y > y + x 证明 x大于y
     * x + y < y + x 证明 x小于y
     * @param nums
     * @return
     */
    public String maxMinNum(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i=0; i< nums.length;i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
