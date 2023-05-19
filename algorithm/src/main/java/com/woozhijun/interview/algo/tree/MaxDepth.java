package com.woozhijun.interview.algo.tree;

import com.woozhijun.interview.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhijunwoo
 * @create by 2023/5/18 17:23
 * @Desc 二叉树的最大深度
 */
public class MaxDepth {


    /**
     * 深度优先算法
     * @param root
     * @return
     */
    public int maxDepthForDfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
           int leftHeight = maxDepthForDfs(root.left);
           int rightHeight = maxDepthForDfs(root.right);
           return Math.max(leftHeight, rightHeight);
        }
    }

    /**
     * 广度优先算法
     * @param root
     * @return
     */
    public int maxDepthForBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
