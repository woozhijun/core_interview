package com.woozhijun.interview.algo.tree;

import com.woozhijun.interview.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhijunwoo
 * @create by 2023/5/18 16:47
 * @Desc 求二叉树中和为某一值的路径
 */
public class TreeNodeTargetSum {

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }
}
