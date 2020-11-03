package com.woozhijun.structure.description;

import java.util.*;

/**
 * @Author: wuzhijun
 * @Date: 2020/10/30 01:34
 */
public class TreeNode {
    private Object data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode next;

    /**
     *  递归:  翻转二叉树
     *  lc: 226
     * @param root
     * @return
     */
    public TreeNode inverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        inverseTree(root.left);
        inverseTree(root.right);
        return root;
    }

    /**
     *  迭代: 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        //返回处理完的根节点
        return root;
    }

    /**
     * 填充二叉树节点的右侧指针
     * lc: 116
     */
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }
    private void connectTwoNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

    /**
     * 将二叉树展开为链表
     * lc : 114
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    /**
     * 二叉树 前序遍历 lc:144
     */
    public List<Object>  postOrderRecur(TreeNode root) {
        List<Object> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.data);
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        return res;
    }

    public List<Object> preOrderIteration(TreeNode root) {
        List<Object> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.data);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * 中序遍历 迭代
     */
    public List<Object> inorderTraversal(TreeNode root) {
        List<Object> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.data);
            if (root.right != null) {
                root = root.right;
            }
        }
        return res;
    }
}
