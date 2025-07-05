package erchashu.leetcode;

import common.TreeNode;

public class zuidashendu {

    private int maxDepth = 0;

    /**
     * 1. 深度可以用 前序遍历
     * <p>
     * <p>
     * 2. 这里二叉树的深度=根节点的高度。高度用后序遍历
     */

    public int maxDepth(TreeNode root) {
        int depth = 1;
        if (root == null) {
            return 0;
        }
        maxDepth0(root, depth);
        return maxDepth;
    }

    // 前序 求深度

    private void maxDepth0(TreeNode root, int depth) {

        // 2. 这里判断可以不写，因为下面只有left、right不为null 才进行递归。所以root一定不为null

        if (root == null) {
            return;
        }
        if (maxDepth < depth) {
            maxDepth = depth;
        }

        // 1. 这里也可以是 如果子节点了跳过 不够子节点要参与判断。

//        if (maxDepth < depth) {
//            maxDepth = depth;
//        }

        // 这种表明是叶子节点的递归结束写法。 但是往往叶子节点也需要处理的

//        if (root.left == null && root.right == null) {
//            return;
//        }


        if (root.left != null) {
            depth++;
            maxDepth0(root.left, depth);
            depth--;
        }
        if (root.right != null) {
            depth++;
            maxDepth0(root.right, depth);
            depth--;
        }
    }


    // 后序求高度， 这里特殊的是 根节点的高度就是树的深度
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后序遍历 求高度，左右子高度+1
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }


}
