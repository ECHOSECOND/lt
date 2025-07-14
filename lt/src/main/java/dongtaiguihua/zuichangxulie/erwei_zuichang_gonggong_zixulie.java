package dongtaiguihua.zuichangxulie;

public class erwei_zuichang_gonggong_zixulie {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * 1. 注意前面 是连续子数组！！！所以看的是 斜对角！！
         *
         * 2. 这里是子序列，不要求连续！！
         *
         * 3. 只需要关注 左和上即可。 左和上是 其中一个序列少一个字符。 斜对角是 两个都少一个字符 显然 不如少一个字符的公共序列长！！
         *
         * 当对应位置 相同时，可以是 关注 左上角 也就是各去掉一个字符后的比较结果
         */

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 第一行 第一列无意义设置为0 不用初始化就是0

        // 从1，1开始 表示 m、n序列的第0的字符开始比较

        int max = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                // 虽然 dp[m][n] 是最大的结果 但是max这么写 也能将m、n囊括进来
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
