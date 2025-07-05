package erchashu.leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class erchashuyoushitu {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView0(root, 0, res);
        return res;
    }


    // 1. depth层或者深度的通用写法。depth+1不用回溯。
    private void rightSideView0(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 2. 技巧：每一层我们取一个元素 if (res.size() == depth) 就表明 这一层的 第一个元素 层从0开始。
        // depth每一层，每一层的深度。
        if (res.size() == depth) {
            // 表明这是这一层最先看到的节点
            res.add(root.val);
        }
        // 4. 最先看到的节点是右节点 先右节点一步到底
        rightSideView0(root.right, depth+1, res); // 3.depth+1不用回溯。
        rightSideView0(root.left, depth+1, res);
    }
}
