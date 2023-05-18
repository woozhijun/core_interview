package com.woozhijun.interview.structure;

import java.util.Stack;

/**
 * @Author: wuzhijun
 * @Date: 2020/10/30 01:34
 */
public class ListNode {
    public Object data;
    public ListNode next;

    /**
     * 使用栈 方法一
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.empty()) {
            return null;
        }
        ListNode node = stack.pop();
        ListNode dummy = node;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            node.next = temp;
            node = node.next;
        }
        node.next = null;
        return dummy;
    }

    /**
     * 使用双链表
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode temp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = temp;
        }
        return newHead;
    }

    /**
     * 递归解决 方法三
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverseList3(head.next);
        // reverse是反转之后的链表，因为函数reverseList
        // 表示的是对链表的反转，所以反转完之后next肯定
        // 是链表reverse的尾结点，然后我们再把当前节点
        //head挂到next节点的后面就完成了链表的反转。
        head.next.next = head;
        //这里head相当于变成了尾结点，尾结点都是为空的，
        //否则会构成环
        head.next = null;
        return reverse;
    }

    public ListNode reverseList4(ListNode head) {
        return reverseListInt(head, null);
    }
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
