package dongtaiguihua;

import java.util.Arrays;

public class donggui_wanquan_pingfangshu {
    /**
     * 平方数
     *
     */

    public int numSquares(int n) {
        // 跟乘积最大很像

        // 对于n而言，乘积是可以由 1 - n-1 作为left，right： 1-left ;left、right组成

        // 对于平方和问题。 n由 1到x^2<=n构成


        int[] dp = new int[n + 1];

        // 注意要初始化为最大值。
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; Math.pow(j,2) <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (int)Math.pow(j,2)] + 1);
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        donggui_wanquan_pingfangshu obj = new donggui_wanquan_pingfangshu();
        System.out.println(obj.numSquares(12));
    }

}
