package shuzhizhen;

public class jieyushui {
    public int trap(int[] height) {
        // 1. 按照逐个列来计算雨水
        // 思路：我们求解一共可以接多少雨水 先考虑某个格子 i 能接多少雨水
        // 位置i能接的雨水 = Min(i左侧最高格子，i右侧最高格子) - height[i]
        // 注意 i左侧/右侧最高格子是包含自己的。
        // 极端情况 i左侧/右侧 最高格子都是自己，那么 Min(i左侧最高格子，i右侧最高格子) - height[i] =0
        // i左侧/右侧最大高度 其中一个是自己，要么左侧/右侧比其高，那么 取两者最小值 取到自己 - 自己的高度会是0
        // 要么左右侧比其低，那么 左右侧两个都是自己。i左侧/右侧最高格子是包含自己的

        // i左侧最高格子计算

        int m = height.length;
        int[] leftMax = new int[m];
        int[] rightMax = new int[m];
        int res = 0;
        // 2. 初始化两边
        leftMax[0] = height[0];
        rightMax[m - 1] = height[m - 1];

        // 4. 这种提前计算i左右两侧的最大高度，其实是避免 计算到i时 左右两侧遍历一遍，形成 On2 时间复杂度
        for (int i = 1; i < m; i++) {
            // 如果当前height不够高，就取前面的。 甚至有可能取到第一个高度 也就是初始值
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            // 如果当前height不够高，就取后面的i+1。 甚至有可能取到最后第一个高度
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // 3. 最外侧两个不可能盛雨水
        for (int i = 1; i < m-1; i++) {
            // 左边最高的、右边最高的取min
            res+= Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    /**
     * 1. 单调栈 左侧一定是比其大的， 遍历过程，右侧【后续日子温度大于左侧】如果遇到了 第一个比它大的说明形成了凹槽 可以接住雨水。
     *
     * 因为一旦发现添加的柱子高度大于栈头元素了，此时就出现凹槽了，栈头元素就是凹槽底部的柱子，栈头第二个元素就是凹槽左边的柱子，而添加的元素就是凹槽右边的柱子。
     */
}
