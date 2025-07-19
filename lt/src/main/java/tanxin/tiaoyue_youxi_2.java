package tanxin;

public class tiaoyue_youxi_2 {

    // 返回最小跳跃次数
    public int jump(int[] nums) {
        // 当前覆盖范围 需要把i遍历完当前覆盖范围
        int curCover = 0;
        // 下一步的最大覆盖范围
        int maxCover = 0;
        // 最小跳跃
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCover = Math.max(maxCover, i + nums[i]);

            // 只有把当前覆盖范围 穷尽了即 i=curCover 才决定下一步继续此过程


            // 之前求是否能到达，只是不断更改覆盖范围，让i能够不断拓宽边界去遍历看看 能不能到nums.length-1
            if (i == curCover) {
                step++;
                curCover = maxCover;
                if (maxCover >= nums.length - 1) {
                    return step;
                }
            }
        }
        return -1;
    }
}
