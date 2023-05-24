package com.woozhijun.interview.structure;

import java.util.Stack;

/**
 * @author zhijunwoo
 * @create by 2023/5/22 16:16
 * @Desc 排序栈，对栈进行排序使最小元素位于栈顶
 */
public class SortedStack {

    Stack<Integer> stack;
    /**
     * 辅助栈
     */
    Stack<Integer> temp;

    public SortedStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        while (!stack.isEmpty() && stack.peek() < val) {
            temp.push(stack.pop());
        }
        stack.push(val);
        while (!temp.isEmpty()) {
            stack.push(temp.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


}
