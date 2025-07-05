package erchashu.leetcode;

import common.TreeNode;

public class sousuoshudiK {
    private int num = 0;
    private int knum = 0;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest0(root,k);
        return knum;
    }

    public void kthSmallest0(TreeNode root, int k) {
        if (root ==null){
            return;
        }
        // 中序遍历 升序
        kthSmallest0(root.left, k);
        // 这里第一次遇到 root 就是最小元素。

        // 1. 利用搜索树中序遍历 有序 数字从小到大从这里经过。第kNum经过的就是 第K小

        num++;
        if (num == k){
            knum = root.val;
            return;
        }
        kthSmallest0(root.right, k);
    }
}
