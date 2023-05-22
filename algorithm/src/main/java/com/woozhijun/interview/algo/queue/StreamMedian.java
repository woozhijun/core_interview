package com.woozhijun.interview.algo.queue;

import java.util.PriorityQueue;

/**
 * 实现中位数
 * @Author: wuzhijun
 * @Date: 2021/11/6 15:42
 */
public class StreamMedian {

        public PriorityQueue<Integer> leftQueue;
        public PriorityQueue<Integer> rightQueue;

        public StreamMedian() {
            leftQueue = new PriorityQueue<Integer>((i,j) -> (i - j));
            rightQueue = new PriorityQueue<Integer>((i,j) -> (j - i));
        }

        public void appendNumber(int a) {

            if (leftQueue.isEmpty() || a < leftQueue.peek()) {
                leftQueue.offer(a);

                if (rightQueue.size() + 1 < leftQueue.size()) {
                    rightQueue.offer(leftQueue.poll());
                }
            } else {
                rightQueue.offer(a);
                if (rightQueue.size() + 1 > leftQueue.size()) {
                    leftQueue.offer(rightQueue.poll());
                }
            }
        }

        public int getMedian() {

            if (leftQueue.size() > rightQueue.size()) {
                leftQueue.peek();
            }
            return (leftQueue.peek() + rightQueue.peek()) / 2;
        }
}
