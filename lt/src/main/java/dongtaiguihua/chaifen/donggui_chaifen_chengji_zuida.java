package dongtaiguihua.chaifen;

public class donggui_chaifen_chengji_zuida {
    public int integerBreak(int n) {

        // 1. 如何将i拆分呢。 i可以是 pair对: left：从1开始到i-1（j）；right：i-j

        // 2. 定义dp[i] 为拆分i的最大乘积。 当 i拆分为 j和i-j时，
        // 要么是 j * (i-j) 要么是 j* dp[i-j] 看哪个更大
        // 注意 i拆分为 j和i-j 有多种情况 还要取max
        // dp[i] = Max(Max(j*(i-j), j*(dp[i-j])))

        // 3. 初始化
        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            // 将i从1开始拆分
            for (int j = 1; j <= i; j++) {
                // 拆分为 j和i-j
                // 注意每一次循环（拆分） dp[i]都会更新， dp[i]要取最大的。 所以 要与dp[i] 取max
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        donggui_chaifen_chengji_zuida c = new donggui_chaifen_chengji_zuida();
        System.out.println(c.integerBreak(10));
    }

}
