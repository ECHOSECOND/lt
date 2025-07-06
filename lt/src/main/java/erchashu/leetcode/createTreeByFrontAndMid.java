package erchashu.leetcode;

import common.TreeNode;

public class createTreeByFrontAndMid {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1. 入参序列和序列的起始、终止位置，出参为TreeNode

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 2. 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 一般构建树采用前序遍历
        // 前序: 根左右 中序： 左中根
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        // 中序找根节点
        int rootPos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootPos = i;
            }
        }
        int leftLen = rootPos - inStart;
        // 左子树 前序： preStart+1, preStart+rootPos；中序: inStart, rootPos-1
        // 右子树 前序:  preStart+rootPos+1,preEnd；中序: rootPos+1, inEnd

        // 前序利用长度 中序用rootPos

        root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inStart, rootPos-1);
        root.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, rootPos+1, inEnd);
        return root;
    }
}
