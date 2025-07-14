package dongtaiguihua.zuichangxulie;

import java.util.Arrays;

public class zuichang_shangsheng_zixulie {
    /**
     * 1. 首先明确 子序列。
     * <p>
     * 子序列是 序列的一部分 但是 不要求连续
     * <p>
     * 2. 对于当前位置 i 而言，它需要与 i 之前的所有元素比较。 而不是 只与 i-1比较
     * <p>
     * 与i之前的所有元素比较 取max 为 dp[i]
     */

    public int lengthOfLIS(int[] nums) {

        int maxResult = 1;

        // 1. 定义 dp[i] 为到元素i 最长的子序列
        int[] dp = new int[nums.length];

        // 2. 初始化 有的时候初始化不要只看 dp[0] 这里是所有序列都为1
        // 有的时候是第一行、第一列的初始化。
        // 初始化要看全局！！

        // 全部设置为1 用Arrays.fill
        Arrays.fill(dp, 1);

        // 3. dp推导
        for (int i = 1; i < nums.length; i++) {
            // i需要与i之前的所有元素比较
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // dp[i]随着与i之前元素的比较会一直在变 而不是只与i-1比较
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 最终结果 dp[i] 不一定是最大的需要
            maxResult = Math.max(maxResult, dp[i]);
        }

        // 最后一个位置的最长序列 不一定是最大的。
        return maxResult;

    }

    public static void main(String[] args) {
        zuichang_shangsheng_zixulie z = new zuichang_shangsheng_zixulie();
        System.out.println(z.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
