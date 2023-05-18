package com.woozhijun.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wuzhijun
 * @Date: 2021/8/13 00:02
 */
public class Solution {

    /**
     * 三数之和(不重复三元组)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    public static int[] sortBy(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, -1, -3, 8, 6, 2};
        int[] result = sortBy(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
