package putongshuzu;

public class zuidazishuzuhe {
    // 最大子数组和
    // 1. 定义dp[i] 为0-i范围内的最大子数组和 不一定从0开始 如果从0开始那么最后的位置就是最大的
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 注意要将nums[0]考虑进去！！所以 max 初始化为 nums[0]
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 2. dp特点，对于当前i而言!!!， 前者大于0 对当前i有益 就加上dp[i-1]
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
