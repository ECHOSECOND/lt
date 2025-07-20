package dongtaiguihua;

import java.util.Arrays;

public class donggui_lingqian_duihuan {
    public int coinChange(int[] coins, int amount) {
        // 相当于也是拆分 amount

        int[] dp = new int[amount + 1];

        // 注意这里的初始化不能 赋值为 Integer.max 因为后面会进行+1 导致溢出！！！
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // 可以尝试拆分
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount]==amount + 1?-1:dp[amount];

    }

    public static void main(String[] args) {
        donggui_lingqian_duihuan d = new donggui_lingqian_duihuan();
        System.out.println(d.coinChange(new int[]{1, 2, 5}, 11));
    }

}
