package com.woozhijun.interview.algo.string;

/**
 * @author zhijunwoo
 * @create by 2023/5/23 16:49
 * @Desc 长度最小的子数组
 */
public class MinSubArrayLen {

    /**
     * 滑动窗口 O(n)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        // 窗口最小的
        int start = 0, end = 0;
        int sum = 0;
        while (end < len) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
