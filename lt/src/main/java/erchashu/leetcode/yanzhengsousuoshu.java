package erchashu.leetcode;

import common.TreeNode;

public class yanzhengsousuoshu {
    Integer prev;// 用Integer表明第一次赋值
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        // 1. 二叉搜索树要么是 搜索
        // 2. 要么是中序遍历
        // 3. 我们用prev记录上一个节点，当前节点需要大于上一个节点

        isValidBST0(root);
        return flag;
    }

    public void isValidBST0(TreeNode root) {

        // 1. 二叉搜索树要么是 搜索
        // 2. 要么是中序遍历
        // 3. 我们用prev记录上一个节点，当前节点需要大于上一个节点

        if (root == null) {
            return;
        }

        isValidBST(root.left);
        int cur = root.val;
        // prev是先用后赋值
        if (prev!=null && cur <= prev) {
            flag = false;
        }
        prev = cur;
        isValidBST(root.right);
    }
}
