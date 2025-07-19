package tanxin;

public class tiaoyue_youxi_1 {
    public boolean canJump(int[] nums) {
        // 当前下标i+当前元素值 nums[i] 就是可触及的最大下标

        int len = nums[0];

        // 不断更新 for 循环能触达的最大位置。 注意会取最大值
        // 更改for循环的最大位置，这样 去遍历到最大位置 判断 i 是否满足要求即可！

        // 不断更改覆盖范围/可循环的范围
        for (int i = 1; i <= len && i <= nums.length - 1; i++) {
            if (i + nums[i] >= nums.length - 1) return true;
            len = Math.max(len, i + nums[i]);
        }
        return len >= nums.length - 1;
    }


    public boolean canJump2(int[] nums) {
        // 核心点有两个：
        // 1. 每个位置可跳的最大距离为 i+nums[i]
        // 2. 可以跳到哪些位置。 相当于 2的判断依赖1 来看

        // 其中 2 可以跳到哪些位置，一开始是从0开始的，nums【0】就是可以跳到的位置

        int max = 0;
        for (int i=0;i<nums.length;i++){
            // 表明可以跳到的位置
            if (i<=max){
                int distance = i+nums[i];
                max= Math.max(max,distance);
                if (max>=nums.length-1){
                    return true;
                }
            }
        }
        return max>=nums.length-1;
    }

}
