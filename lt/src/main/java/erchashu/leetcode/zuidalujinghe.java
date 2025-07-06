package erchashu.leetcode;

import common.TreeNode;

public class zuidalujinghe {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /**
         * 1. 我们之前处理的路径要么是 全路径 node.left && right 均为null的情况
         *
         * 要么是其中一条路径 但必须是从父到子 下来的 比如 全路径 5 3 4 1
         *
         * 我们 5 3、5 3 4 这个途中要处理， 且从后往前处理 这样能把 父到子路径 穷举完。
         *
         * 2. 这里不是父到子的某条路径，而是经过 root节点 可能左中右构成一条路径->节点最大值: cur+left+val
         * 但注意节点能贡献给父节点使用的 只是cur+左/右其中一个节点，而不是 当前节点的最大值！！！
         *
         * 3. cur节点的路径和，cur+左右贡献增益的；
         * 全局的微各个cur节点的最大值
         */
        maxPathSum0(root);
        return max;
    }

    private int maxPathSum0(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPathSum0(root.left), 0);
        int right = Math.max(maxPathSum0(root.right), 0);
        int nodeMax = root.val + left+ right;
        max = Math.max(max, nodeMax);
        // 节点的最大贡献值， 只能是 root 与 left或者right 其中一个 组成的路径！！！
        return root.val+Math.max(left, right);
    }
}
