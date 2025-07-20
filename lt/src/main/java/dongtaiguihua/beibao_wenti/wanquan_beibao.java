package dongtaiguihua.beibao_wenti;

import java.util.Scanner;

public class wanquan_beibao {
    /**
     * 1. 总体思路 背包和完整背包 问题 都是 两个维度：
     *
     * 1）有这些物品。 2) 能不能凑齐某个目标值，可以是一个数值 可以是一个字符串
     *
     * 像这种能不能凑起来的 都可以用bool来定义 二维dp
     *
     *
     * 2. 完全背包就是元素可以重复用。 dp[i][j] = dp[i-1][j](不用 取决于上一个状态), dp[i][j-nums[i]]（用了背包容量减少 但是i不变因为可以重复用。）
     *
     * 01 背包 元素不可以重复用。 dp[i][j] = dp[i-1][j] 不用 ， dp[i-1][j-nums[i]] 用了但是只能是上一个物品的，因为dp[i] 表明是当前物品
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagWeight = scanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[][] dp = new int[n][bagWeight + 1];

        // 初始化

        // 注意这个初始化。之前都是 weight[0] <=j, 将此位置处 设置为 weight[0]

        // 这里是 看 dp[0][j - weight[0]] + value[0];

        // 其实可以 声明为 dp m+1,n+1 就不会有这样的问题了。

        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        // 动态规划
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n - 1][bagWeight]);
        scanner.close();
    }

}
