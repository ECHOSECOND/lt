package erchashu.leetcode;

import common.TreeNode;

public class lujinghe {


    public boolean hasPathSum(TreeNode root, int sum) {

        //上层 下发下来、节点为 null 表明已经穷尽了 不然 sum =0 在上层已经 返回了、

        if(root==null) return false;

        //一、先看 本节点 是否满足 和 为 sun 了；二、不满的话 将差 传递下一层、、下一层 如果为 null 了、直接返回 false、

        //因为上一层 肯定是 不满足 条件 才将 差下发；下发所至的 节点 为 null 了、证明穷尽 也没满足了  返回 false！ 即 root==null 返回 false 即可！！

        // 1. 注意我们 是把 nowSum 计算好了直接传入，这样 left和right不会相互影响，也就是不用进行回溯撤销！！
        int nowSum = sum-root.val;

        // 2. sum==0 以及 左右子节点为空了 说明找到那条路径了！
        if(nowSum==0 && root.left==null && root.right==null) return true;

        //说明本节点 处不可以 、依然是 sum !=0 的、继续下发、


        return hasPathSum(root.left,nowSum) || hasPathSum(root.right,nowSum);

    }
}
