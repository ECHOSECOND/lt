package paixu;

import common.Util;

import java.util.Arrays;

public class maopao {
    public static void main(String[] args) {
        maopao maopao = new maopao();
        int[] nums= new int[]{5,2,3,1};
        maopao.maopao(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void maopao(int[] nums) {
        // 外层循环控制轮数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                // 将j从0到nums.length-i范围冒泡一遍
                if (nums[j] > nums[j+1]) {
                    Util.swap(nums, j,j+1);
                }
            }
        }
    }
}
