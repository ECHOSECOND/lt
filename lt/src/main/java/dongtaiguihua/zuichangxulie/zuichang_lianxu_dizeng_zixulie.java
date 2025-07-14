package dongtaiguihua.zuichangxulie;

import java.util.Arrays;

public class zuichang_lianxu_dizeng_zixulie {
    public int findLengthOfLCIS(int[] nums) {
        // 1. 因为本题要连续 所以是 i 与 i-1 的比较

        // 2. 定义dp[i] 为到i位置处的最长递增序列
        // 全局初始化 dp[i]=1

        /**
         * 不连续递增子序列的跟前0-i 个状态有关，连续递增的子序列只跟前一个状态有关
         */

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // 3. 遍历

        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        zuichang_lianxu_dizeng_zixulie z = new zuichang_lianxu_dizeng_zixulie();
        System.out.println(z.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

}
