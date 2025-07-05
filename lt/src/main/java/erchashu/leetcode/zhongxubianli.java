package erchashu.leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class zhongxubianli {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal0(root, res);
        return res;
    }

    private void inorderTraversal0(TreeNode root, List<Integer> res) {
        if (root ==null){
            return;
        }
        inorderTraversal0(root.left, res);

        /**
         * 1. 左根右 的顺序
         */

        res.add(root.val);
        inorderTraversal0(root.right, res);
    }
}
