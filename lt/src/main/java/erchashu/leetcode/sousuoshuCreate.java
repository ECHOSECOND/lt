package erchashu.leetcode;

import common.TreeNode;

public class sousuoshuCreate {

    /**
     * 二叉树的构建一般都是 前序遍历
     * @param nums
     * @return
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        // 采用指针的方式避免数组拷贝
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        // 1. 入参 数组和边界 出参是节点
        // 2. 递归条件
        if (start > end) {
            return null;
        }
        // 3.单层逻辑
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
}
