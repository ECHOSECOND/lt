package common;

import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public List<TreeNode> children; // N 叉树的场景
    public TreeNode(int x) {
        val = x;
    }
}
