package erchashu.suixianglu.cengcibianli;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class N_chashu_cengci_bianli {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<List<Integer>>();
            }

            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int cnt = queue.size();
                List<Integer> level = new ArrayList<Integer>();
                for (int i = 0; i < cnt; ++i) {
                    TreeNode cur = queue.poll();
                    level.add(cur.val);

                    // 注意树的 bfs 不需要跟图一样 通过 visted 去避免重复访问，天然就是不重复的！找子节点！！无环！！

                    for (TreeNode child : cur.children) {
                        queue.offer(child);
                    }
                }
                ans.add(level);
            }

            return ans;
        }
    }
}
