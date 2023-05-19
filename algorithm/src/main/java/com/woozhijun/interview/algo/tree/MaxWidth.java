package com.woozhijun.interview.algo.tree;

import com.woozhijun.interview.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhijunwoo
 * @create by 2023/5/18 17:40
 * @Desc 二叉树最大宽度
 */
public class MaxWidth {

    Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

    public int maxWidthForDfs(TreeNode root) {
        return dfs(root, 1, 1);
    }
    /**
     * 深度优先
     * @param root
     * @param depth 深度
     * @param index 位置
     * @return index的左子节点的编号记为 2*index; 右子节点编号记为2*index+1
     */
    public int dfs(TreeNode root, int depth, int index) {
        if (root == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index);
        // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(root.left, depth + 1, index * 2), dfs(root.right, depth + 1, index * 2 + 1)));
    }

}
