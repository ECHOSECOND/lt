package erchashu.leetcode;

import common.TreeNode;

public class erchashuduichen {
    public boolean isSymmetric(TreeNode root) {
        // 1. 确定递归函数的入参和返回值 入参数是左右子节点 当作两个子树
        // 返回值是bool
        return isSymmetric0(root, root);
    }

    private boolean isSymmetric0(TreeNode root, TreeNode root1) {
        // 2. 递归结束条件

        // 其实很多逻辑就写在了递归结束这里
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }

        if (root.val != root1.val) {
            return false;
        }

        // 3. 单层逻辑。虽然是后序遍历，但是很多逻辑是写在 前面递归结束那里
        return isSymmetric0(root.left, root.right) && isSymmetric0(root.right, root.left);
    }
}
