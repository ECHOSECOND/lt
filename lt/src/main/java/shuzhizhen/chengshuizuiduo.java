package shuzhizhen;

public class chengshuizuiduo {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     */

    public int maxArea(int[] height) {
        // 保持尽量大的宽度开始。 每一个宽度找最大的高度，所有的宽度与最大的高度乘积 作为面积最大值
        // 两边移动的往往考虑 双指针； 双指针是一左一右！！
        int i = 0;
        int j = height.length - 1;
        int area=0;
        while (i <= j) {
            // 每一个宽度下 保留更高的。
            int w = j - i;
            int h;
            // 看看哪个高度更低
            // 保留更高的，将低的移动
            if (height[i] < height[j]) {
                h = height[i];
                i++;
            }else {
                h = height[j];
                j--;
            }
            area = Math.max(area, w*h);
        }
        return area;
    }
}
