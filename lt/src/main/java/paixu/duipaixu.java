package paixu;

import java.util.Arrays;

public class duipaixu {
    /**
     * 堆的基本概念
     * 堆是一种特殊的完全二叉树，分为两种类型：
     * <p>
     * 最大堆：每个节点的值都大于或等于其子节点的值
     * <p>
     * 最小堆：每个节点的值都小于或等于其子节点的值
     * <p>
     * 堆通常用数组来表示，对于数组中的第i个元素：
     * <p>
     * 父节点位置：(i-1)/2
     * <p>
     * 左子节点位置：2i+1
     * <p>
     * 右子节点位置：2i+2
     */

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        duipaixu duipaixu = new duipaixu();
        duipaixu.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        duisort(nums);
        return nums;
    }

    private void duisort(int[] nums) {
        // 1. 首先构建大顶堆。 从非叶子节点开始构建

        // 2. 调整过程 节点往下调整。 一直与左右子节点比较。 只不过构建堆是从倒数第一个非叶子节点往下调整

        // 排序是堆顶 的第一个非叶子节点调整

        for (int i = nums.length / 2; i >= 0; i--) {
            // 注意构建堆时调整范围
            adjust(nums, i, nums.length - 1);
        }

        // 排序
        // 3. 排序 注意 与 nums.length - 1 - i 进行交换。 i一开始为最后一位，渐渐的 最后一位排好序
        // 应该将其排除在排序 和 构建堆的范围内！！！ nums.length - 1 - i 是排序交换的；nums.length - 2 - i 是构建堆的范围
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - 1 - i);
            adjust(nums, 0, nums.length - 2 - i);
        }

    }

    private void adjust(int[] nums, int pos, int end) {
        // 如果存在左子节点
        while (pos * 2 + 1 <= end) {
            // 左右子节点选一个大的
            int bigger = pos * 2 + 1;
            if (pos * 2 + 2 <= end) {
                bigger = nums[pos * 2 + 2] > nums[pos * 2 + 1] ? pos * 2 + 2 : pos * 2 + 1;
            }
            // bigger与pos比较决定是否交换
            if (nums[bigger] <= nums[pos]) {
                break;
            }
            swap(nums, bigger, pos);
            pos = bigger;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
