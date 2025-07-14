package dongtaiguihua.huiwen_zichuan;

public class zuichang_huiwen_zixulie_dp {
    /**
     * 子序列不要求连续
     * <p>
     * 也就是 dp[i][j]是否为回文子串 不需要依赖 dp[i+1][j-1]
     * <p>
     * 只要i==j 直接+2
     *
     * 回文是开始、结束 i、j比较 是两维的！！！
     */

    public int longestPalindromeSubseq(String s) {
        // 因为dp[i][j] 还是依赖  dp[i+1][j-1] 从下往上 从左往右 一开始 i=s.length-1;j=i

        // 因为子串处理时，一开始i==j 单独处理 所以没有越界问题！

        // 子序列是直接定义结果， 子串是定义的bool是否为回文串【先判断整体是不是回文串再计算】

        int[][] dp = new int[s.length()][s.length()];
        int max = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            // 因为是 i-j 区间，j一定是 >=i 的！！！

            // i、j 区间 ，二维dp！！！
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 单独处理避免越界
                    if (i == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // 注意从下到上 从左到右 i依赖i+1； j依赖j-1
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        zuichang_huiwen_zixulie_dp xulie = new zuichang_huiwen_zixulie_dp();
        System.out.println(xulie.longestPalindromeSubseq("bbbab"));
    }

}
