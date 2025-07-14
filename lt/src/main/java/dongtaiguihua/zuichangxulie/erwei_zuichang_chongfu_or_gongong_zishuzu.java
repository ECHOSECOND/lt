package dongtaiguihua.zuichangxulie;

public class erwei_zuichang_chongfu_or_gongong_zishuzu {
    /**
     * 1. 涉及到公共 一般都是 两个序列作为 输入
     * <p>
     * 2. dp[i][j] 的定义
     * dp[i][j] 表示：
     * <p>
     * 以 A[i-1] 结尾的子数组 和 以 B[j-1] 结尾的子数组 的最长公共后缀长度（即最长重复子数组的当前匹配长度）。
     * <p>
     * 为什么从 i-1 和 j-1 开始？
     * <p>
     * 为了方便初始化，避免处理负下标（如 dp[0][0] 表示 A[-1] 和 B[-1] 无意义）。
     * <p>
     * 通过从 i=1, j=1 开始遍历，dp[i][j] 实际对应 A[0..i-1] 和 B[0..j-1] 的匹配情况。
     * <p>
     * 注意 dp[i][j] 从1,1开始遍历，这样就对应 从 0,0 结尾开始的实际序列
     * <p>
     * 3. 所以要 初始化为 序列长度+1
     */

    public int findLength(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

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
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        erwei_zuichang_chongfu_or_gongong_zishuzu erwei = new erwei_zuichang_chongfu_or_gongong_zishuzu();
        System.out.println(erwei.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }


}
