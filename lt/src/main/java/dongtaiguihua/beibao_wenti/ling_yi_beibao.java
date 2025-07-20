package dongtaiguihua.beibao_wenti;

import java.util.ArrayList;
import java.util.List;

public class ling_yi_beibao {

    /**
     * 1. 背包问题 涉及选择与不选的问题
     * <p>
     * 跟二叉树两种选择很像
     * <p>
     * 2. 二叉树回溯写法 平铺写两种情况
     * <p>
     * 除了纯二叉树的 可以逻辑写在 外面 其余的统一写法，写在里面
     */

    private List<Integer> path = new ArrayList<>();

    private int maxValue = -1;


    // 回溯写法
    public int knapsackByHuisu(int[] weights, int[] values, int W) {
        // 1. weights 相当于每一件物品， values 是其对应的价值
        knapsack(weights, values, W, 0);
        return maxValue;
    }

    // dp写法
    public int knapsackByDp(int[] weights, int[] values, int W) {
        // 1. 考虑到包含 物品数和空间 两个维度
        // 即dp[i][j] 为物品数为i时，背包容量为j时的最大价值

        // 2. 只要物品数定了，其 values 价值也就定了

        // 字符串问题 往往length+1

        int[][] dp = new int[weights.length][W];
        int m = weights.length;
        int n = W;

        // 一般初始化一行或者一列

        // 第一行是 第0个物品 完全看背包是否够

        for (int i = 0; i < n; i++) {
            dp[0][i] = (i >= weights[0]) ? values[0] : 0;
        }

        // 第一列是0

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // j是否够装
                if (j >= weights[i]) {
                    // 再去选择装与不装
                    // 不装 dp[i-1][j] 装了 dp[i-1][j-weight[i]]
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]]+values[i], dp[i - 1][j]);
                } else {
                    // 不够装
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length - 1][W - 1];
    }

    private void knapsack(int[] weights, int[] values, int w, int index) {
        if (index >= weights.length) {
            if (sumPath(path, weights) <= w) {
                // 计算价值
                maxValue = Math.max(maxValue, totalVal(path, values));
            }
            return;
        }
        // 平铺写两种选择
        // 选择
        if (sumPath(path, weights) < w) {
            path.add(index);
            knapsack(weights, values, w, index + 1);
            path.remove(path.size() - 1);
        }
        // 不选择
        knapsack(weights, values, w, index + 1);

    }

    private int totalVal(List<Integer> path, int[] values) {
        int total = 0;
        for (int i : path) {
            total += values[i];
        }
        return total;
    }

    private int sumPath(List<Integer> path, int[] weights) {
        int total = 0;
        for (int i : path) {
            total += weights[i];
        }
        return total;
    }

    public static void main(String[] args) {
        ling_yi_beibao l = new ling_yi_beibao();
        int[] weights = {2, 4, 1};
        int[] values = {10, 5, 4};
        System.out.println(l.knapsackByDp(weights, values, 5));
    }


}
