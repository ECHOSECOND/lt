package erchashu.leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class erchashucengcibianli {
    /**
     * 递归法是深度优先遍历
     *
     * 层次队列法是 广度优先遍历
     *
     * 都是遍历整个二叉树
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. queue模拟队列和栈
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            // 2. 每一层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                // 按顺序添加left、right
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 3. 处理每一层的结果
            result.add(level);
        }
        return result;
    }

}
