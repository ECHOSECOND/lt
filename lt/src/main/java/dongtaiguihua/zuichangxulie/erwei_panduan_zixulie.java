package dongtaiguihua.zuichangxulie;

public class erwei_panduan_zixulie {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        // 1. 第一行、第一列都是没有意义的。 初始化为0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }


        // 3. 一般定义max是对的，就算 取dp[m][n] 那max取最大值也能去到 dp[m][n]
        int max=0;

        // 2. 从1，1开始 对应数组 从0，0开始
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 从 1，1开始 对应原数组从0，0开始
                if (nums1[i - 1] == nums2[j - 1]) {

                    // dp[i][j] 基本就是与上下左右有关，这里是 对角
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    // 3. 一定注意 子序列 需要处理 非斜对角的情况！！！ 连续子序列或者子数组才可以只考虑斜对角！！
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max == s.length();
    }

    public static void main(String[] args) {
        erwei_panduan_zixulie p = new erwei_panduan_zixulie();
        p.isSubsequence("abc", "ahbgdc");
    }

}
