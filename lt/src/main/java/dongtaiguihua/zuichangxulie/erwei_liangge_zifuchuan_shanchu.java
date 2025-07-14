package dongtaiguihua.zuichangxulie;

public class erwei_liangge_zifuchuan_shanchu {
    /**
     * 1. 涉及长短字符串转换 但是没有明确知道哪个长短 假定第一个长
     *
     * 2. 一般就是讨论 arr1（或者序列）【m】 与 arr2【n】相等与不相等的情况
     */

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        // 第一列初始化为m的长度 除了 0，0 处为0
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        // 第一行初始化为n的长度
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意从1，1开始，但是比较是从 i-1和j-1比较
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        // 二维的一般是 穷尽 两个字符串，取最后一个坐标为结果

        return dp[m][n];

    }

    public static void main(String[] args) {
        erwei_liangge_zifuchuan_shanchu shanchu = new erwei_liangge_zifuchuan_shanchu();
        String word1 = "sea", word2 = "eat";
        System.out.println(shanchu.minDistance(word1, word2));
    }
}
