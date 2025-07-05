package erchashu.leetcode;

import common.TreeNode;

public class fanzhuanerchashu {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        // 1. 可以是后续遍历 将左右子树处理完后，交换 root的left和right

        // 本节点的左右子树 交换完毕后， 相当于 上一层的root.left处理完成 接着处理 上一层root.right 一样的道理。

        // 最终在上一层 将父节点的左右子节点交换。

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
