package erchashu.leetcode;

import common.TreeNode;

public class erchashuzhijing {

    int zhijing=0;

    public int diameterOfBinaryTree(TreeNode root) {
        return zhijing;
    }

    public int diameterOfBinaryTree0(TreeNode root) {
        // 1. 确定出入参 入root 出int

        // 2. 递归结束条件
        if (root == null) return 0;

        // 3.单层逻辑
        // 递归函数是求树的高度 我们所求的直径是 利用树高度， 左树高度、右树高度 相加
        int left = diameterOfBinaryTree0(root.left);
        int right = diameterOfBinaryTree0(root.right);

        // 在求树的高度的递归中 求解下直径

        zhijing = Math.max(left +right, zhijing);

        // 以上是左右子树的高度
        // 本节点的高度
        return Math.max(left, right) + 1;
    }
}
