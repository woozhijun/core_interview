package com.woozhijun.interview.algo.sort;

import java.util.Random;

/**
 * 冒泡排序
 * 通常有三种写法：
 *
 * 1. 一边比较一边向后两两交换，将最大值 / 最小值冒泡到最后一位；
 * 2. 经过优化的写法：
 * 使用一个变量记录当前轮次的比较是否发生过交换，如果没有发生交换表示已经有序，不再继续排序；
 * 3. 进一步优化的写法：
 * 除了使用变量记录当前轮次是否发生交换外，再使用一个变量记录上次发生交换的位置，下一轮排序时到达上次交换的位置就停止比较。
 *
 * @Author: wuzhijun
 * @Date: 2021/8/18 23:32
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = buildArray(10);
        print(nums);
        bubbleSortThree(nums);
        print(nums);
    }

    /**
     * 方法一
     * @param nums
     */
    public static void bubbleSortFirst(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 方法二
     * @param nums
     */
    public static void bubbleSortSecond(int[] nums) {

        boolean swapped = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
        }
    }

    /**
     * 方法三
     * @param nums
     */
    public static void bubbleSortThree(int[] nums) {

        boolean swapped = true;
        // 最后一个没有经过排序的元素的下标
        int indexOfLastUnsortedElement = nums.length - 1;
        // 上次发生交换的位置
        int swappedIndex = -1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    swapped = true;
                    swappedIndex = i;
                }
            }
            // 最后一个没有经过排序的元素的下标就是最后一次发生交换的位置
            indexOfLastUnsortedElement = swappedIndex;
        }
    }

    /**
     * 交换元素
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 随机构建从0 - 1000的数组元素
     * @param n
     * @return arr
     */
    private static int[] buildArray(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }

    /**
     * print 输出元素
     * @param arr
     */
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i] + "\n");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
