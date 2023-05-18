package com.woozhijun.interview.algo.sort;

/**
 * @author wuzj
 * 快速排序
 */
public class Quick {
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		int num[] = {6,1,2,7,9,3,4,5,10,8};
		
		quickSort(0, num.length - 1, num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("\n" + (endTime - startTime));
	}


	/**
	 * 迭代 快排
	 * @param left
	 * @param right
	 * @param num
	 */
	public static void quickSort(int left, int right, int[] num) {
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
		quickSort(left, i - 1, num);
		quickSort(i + 1, right, num);
	}
}