package qita_.gaopinti;

public class zuichang_chongfu_zichuan_or_zishuzu {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];

        int maxLen = 0;

        // 初始化到m
        // 第一行
        for (int i = 0; i <= n; i++) {
            dp[0][i]=0;
        }
        // 第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        // 2. 中间过程可能是最大值的要遍历过程取max，那种要穷尽了才能取结果的，才是dp[m][n]

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 1. 注意子串只关注上一个状态！！！

                // 因为 dp是多申请了一个长度 注意判断nums要 i/j -1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
}
