package dongtaiguihua.beibao_wenti;

public class donggui_chaifen_he_0_1_beibao {
    /**
     * 拆分子集和
     */

    /**
     * 思路：就是背包问题
     * 看能否选取元素 满足背包重量为
     * <p>
     * 只能装重量为 sum / 2 的背包，商品为数字，这些数字能不能把 这个背包装满。
     * <p>
     * <p>
     * 即一个商品如果可以重复多次放入是完全背包，而只能放入一次是01背包，写法还是不一样的。
     * <p>
     * 元素我们只能用一次，如果使用背包，那么也是01背包
     */

    public boolean canPartition(int[] nums) {
        return canPartitionByBool(nums);
    }


    public boolean canPartitionByWeight(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 这就是背包容量
        // 我们选取元素往背包放，看最大 价值/重量 是否恰好为 target /背包容量
        int target = sum / 2;
        if(sum%2!=0){
            return false;
        }

        int m = nums.length;
        int n = target;

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;

        // 第一行 也就是选取第一个物品完全看 背包是否放的开
        for (int i = 1; i < n; i++) {
            dp[0][i] = 0;
        }
        // 第一列为0
        for (int i = 1; i < m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 背包容量够
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 显然是最后一步是最优结果
        return dp[m][n] == target;

    }

    /**
     * 我们定义 dp bool
     * <p>
     * 后面包括完全背包问题 都是 这种bool定义
     * <p>
     * dp[i][j] 为背包重量为j 用i个物品能不能装满
     */


    public boolean canPartitionByBool(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 这就是背包容量
        // 我们选取元素往背包放，看最大 价值/重量 是否恰好为 target /背包容量
        int target = sum / 2;

        if(sum%2!=0){
            return false;
        }

        int m = nums.length;
        int n = target;

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // 第一行 也就是选取第一个物品完全看 背包是否放的开
        for (int i = 1; i < n; i++) {
            dp[0][i] = false;
        }
        // 第一列为0
        for (int i = 1; i < m; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 背包容量够
                if (j >= nums[i - 1]) {
                    // 选与不选
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    // 容量不够 没得选
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 显然是最后一步是最优结果
        return dp[m][n];

    }


}
