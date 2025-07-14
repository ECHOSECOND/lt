package dongtaiguihua.zuichangxulie;

public class zuida_zixulie_he {
    public int maxSubArray(int[] nums) {

        // 定义dp
        // dp[i] 为 到i位置最大的子数组和

        // 注意 子数组要求是连续的！！！所以只需要关注 i-1 而不是0-i 即i之前所有的

        // 就跟二维数组 只需要关注 i-1、j-1 类似

        // 初始化
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        // 定义max取每个位置i处的最大值一定没问题
        int max = dp[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
