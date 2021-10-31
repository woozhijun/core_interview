package com.woozhijun.algorithm.sort;

import java.util.Random;

/**
 * @author wuzj
 * �����򣨺�ȥ�أ�O(M+N)
 */
public class Bucket {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		bucketSort(10, 100);
		long endTime = System.currentTimeMillis();
		System.out.println("\n" + (endTime - startTime));
	}
	
	public static void bucketSort(Integer input, Integer rand) {
		
		int[] book = new int[rand + 1];
		for (int i = 0; i < book.length; i++) {
			book[i] = 0;
		}
		Random r = new Random();
		for (int i = 0; i < input; i++) {
			
			int num = r.nextInt(rand);
			for (int j = 0; j < book.length; j++) {
				
				if (num == j) {
					book[j] ++;
				}
			}
		}
		
		for (int i = book.length -1 ; i >= 0; i--) {
			
			for (int j = 1; j <= book[i]; j++) {
				System.out.print(i + " ");
			}
		}
	}
}