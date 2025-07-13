package dongtaiguihua;

public class zuixiao_huafei_palouti {
    public int minCostClimbingStairs(int[] cost) {

//        楼梯结构：假设 cost = [10, 15, 20]，表示：
//
//        台阶 0 的费用是 10
//
//        台阶 1 的费用是 15
//
//        台阶 2 的费用是 20
//
//        目标：爬到 顶部（即 超出最后一个台阶，这里是台阶 3，索引 i = 3）。

        // 1. 定义dp:dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]。

        int[] dp = new int[cost.length+1]; // 要超出最后一个台阶

        // 2. 递推公式
//        dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        // 3. 初始化

        dp[0] = 0;
        dp[1] = 0;

        // 4. 确定遍历顺序
        // dp[i]由dp[i-1]dp[i-2]推出，所以是从前到后遍历cost数组就可以了。

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
