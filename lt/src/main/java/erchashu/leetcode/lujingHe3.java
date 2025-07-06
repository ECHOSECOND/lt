package erchashu.leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lujingHe3 {
    // 定义从根节点出发的全路径
    private List<Long> path = new ArrayList<>();
    private int count;

    public int pathSum(TreeNode root, int targetSum) {
        pathSum0(root, targetSum);
        return count;
    }

    private void pathSum0(TreeNode root, int targetSum) {
        // 回溯的思想 先将选择加进来 遍历完所有选择后 移除掉！
        // 对于二叉树而言， 选择就是 left、right

        if (root == null) {
            return;
        }

        // 3. 这种写法是 root!=null 时 先将 root.val 处理下

        path.add((long) root.val);

        // 4. 同下，是边往路径加 边判断。 不是像全路径那样 root.left && root.right 都是null了 再做逻辑处理！！
        long sumNow = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sumNow += path.get(i);
            if (sumNow == targetSum) {
                count++;
            }
        }

        // 2. 也可以用这种写法， 处理完root的left和right后 将root回退。

        // 选择
        pathSum0(root.left, targetSum);
        pathSum0(root.right, targetSum);

        // 递归完回退回去 避免影响其它路径
        path.remove(path.size() - 1);
    }


    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        path.add((long)root.val);
        pathSum02(root, targetSum);
        return count;
    }

    private void pathSum02(TreeNode root, int targetSum) {
        // 回溯的思想 先将选择加进来 遍历完所有选择后 移除掉！
        // 对于二叉树而言， 选择就是 left、right


        // 4. 是边往路径加 边判断。 不是像全路径那样 root.left && root.right 都是null了 再做逻辑处理！！
        long sumNow = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sumNow += path.get(i);
            if (sumNow == targetSum) {
                count++;
            }
        }

        // 1. 这种写法就跟 回溯模版基本一样了，相当于 展示了for循环选择， 分别处理 left和right
        // 但是这种写法记得单独处理 root节点， 已经不需要递归终止条件了！！！
        if (root.left!=null){
            path.add((long) root.left.val);
            pathSum02(root.left, targetSum);
            path.remove(path.size() - 1);

        }
        if (root.right!=null){
            path.add((long) root.right.val);
            pathSum0(root.right, targetSum);
            path.remove(path.size() - 1);
        }

    }


}
