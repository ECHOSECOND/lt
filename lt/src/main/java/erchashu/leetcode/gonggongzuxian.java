package erchashu.leetcode;

import common.TreeNode;

public class gonggongzuxian {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // 1. 当前节点实际上是利用了左右子节点的返回

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right; // 当前节点实际上是利用了左右子节点的返回。 2. 只要左右子节点不为空 就作为当前节点的返回

    }
}
