package dongtaiguihua.zuichangxulie;

public class erwei_bianji_juli {
    public int minDistance(String word1, String word2) {
        
        // 取第一个为m
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;

        // 第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        // 第一行
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 相等的取左上角
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不相等的
                    // 删除 可能删除word1 可能删除word2
                    int del = Math.min(1 + dp[i - 1][j], 1 + dp[i][j-1]);
                    // 替换
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(del, replace);
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        erwei_bianji_juli juli = new erwei_bianji_juli();
        System.out.println(juli.minDistance("a", "ab"));
    }
}
