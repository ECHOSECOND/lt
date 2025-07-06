package erchashu.leetcode;

import common.TreeNode;

public class erchashuzhankailianbiao {
    private TreeNode head;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // Node的 right 当作next 来进行链表的串联
        // 定义链表的root节点
        // 因为要修改right节点 这里使用 right暂存

        // 1. 要在原树节点上操作更新其left和right，记得要先保存

        TreeNode right = root.right;
        TreeNode left = root.left;
        if (head == null) {
            head = root;
        } else {
            head.right = new TreeNode(root.val);
            head.left = null;
            head = head.right;
        }
        // 先序遍历
        flatten(left);
        flatten(right);
    }
}
