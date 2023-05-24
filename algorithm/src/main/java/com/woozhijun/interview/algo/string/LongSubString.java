package com.woozhijun.interview.algo.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: wuzhijun
 * @Date: 2020/10/18 23:53
 * @Desc  最长子串+长度(不同字符) 问题
 */
public class LongSubString {

    public String longestDupSubstring(String str) {
        int[] arr = new int[str.length()];
        for(int i=0; i<str.length();i++) {
            arr[i] = str.charAt(i) - 'a';
        }
        // 二分法+RK法
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if(checkRK(arr, mid) > 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int start = checkRK(arr, left);
        if (start == -1) {
            return "";
        } else {
            return str.substring(start, start + left);
        }
    }

    final long modulus = (long)Math.pow(2,32);
    final int a = 26;

    private int checkRK(int[] arr, int length) {
        long curHash = 0;
        HashSet<Long> seen = new HashSet<>();
        // 首先统计0----length-1 这个长为length的的哈希值
        for (int i=0; i < length; i++) {
            curHash = (curHash * a + arr[i]) % modulus;
        }
        seen.add(curHash);
        // aL 代表a的L次方
        long aL = 1;
        for (int i=1; i<=length; i++) {
            aL = (aL*a) % modulus;
        }
        // 统计(1----length) (2------length+1) ............ (arr.length-length -----arr.length-1) 的哈希值
        for (int start = 1; start <= arr.length - length; start++) {
            curHash = (curHash * a - arr[start-1]*aL%modulus + modulus) % modulus;
            curHash = curHash + arr[start+length-1] % modulus;
            if (seen.contains(curHash)) {
                return start;
            }
            seen.add(curHash);
        }
        return -1;
    }

    public static void main(String[] args) {
        LongSubString ss = new LongSubString();
        System.out.println(ss.longestDupSubstring("banana"));
        System.out.println(ss.longestDupSubstring("123456"));
        System.out.println(ss.longestDupSubstring("bananacncnc"));
    }


    /**
     * 至多包含K个不同字符的最长子串(滑动窗口 + HashMap)
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubStringForDistinct(String s, int k) {
        int n = s.length();
        if (n < k) {
            return n;
        }
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        while (end < n) {
            map.put(s.charAt(end), end++);
            if (map.size() == k + 1) {
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                start = delIdx + 1;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }

    /**
     * 长度为K的无重复字符子串（固定长度的滑动窗口）
     * @param s
     * @param k
     * @return
     */
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();
        if (k > n) {
            return 0;
        }
        int start = 0;
        int end = n - k;
        int maxLen = 0;

        return maxLen;
    }

    /**
     * 无重复字符的最长子串(滑动窗口 + 哈希)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int start = 0, end = 0;
        int maxLen = 0;
        while (end < n) {
            map.put(s.charAt(end), end++);
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
