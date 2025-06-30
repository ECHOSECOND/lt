package paixu;

import java.util.Arrays;

public class guibingpaixu {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        guibingpaixu guibingpaixu = new guibingpaixu();
        guibingpaixu.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        guibingsourt(nums, 0, nums.length - 1);
        return nums;
    }

    private void guibingsourt(int[] nums, int start, int end) {
        // 1.在左右序列递归结束后 进行两个区间的merge 是后序遍历
        // 递归结束后操作，递归结束 是两个有序区间去做merge

        // 2.条件为 区间有没有结束。 也就是 两个区间分别有 start、end

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        guibingsourt(nums, start, mid);
        guibingsourt(nums, mid + 1, end);


        int leftStart = start;
        int leftEnd = mid;

        int rightStart = mid + 1;
        int rightEnd = end;

        int temp = 0;
        // 定义临时排好序的数组
        int[] sorted = new int[nums.length];
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (nums[leftStart] < nums[rightStart]) {
                sorted[temp] = nums[leftStart];
                leftStart++;
            } else {
                sorted[temp] = nums[rightStart];
                rightStart++;
            }
            temp++;
        }
        // 剩余多的区间还是要继续遍历的
        while (leftStart <= leftEnd) {
            sorted[temp] = nums[leftStart];
            temp++;
            leftStart++;
        }
        while (rightStart <= rightEnd) {
            sorted[temp] = nums[rightStart];
            temp++;
            rightStart++;
        }

        // 原数组拷贝
        for(int i=start;i<=end;i++) {
            nums[i] = sorted[i-start];
        }

    }

    /**拼接两个数组，放到新数组里！
     *
     *
     *         while (i <= mid && j <= r) {
     *             if (nums[i] <= nums[j]) {
     *                 tmp[cnt++] = nums[i++];
     *             }
     *             else {
     *                 tmp[cnt++] = nums[j++];
     *             }
     *         }
     *         while (i <= mid) {
     *             tmp[cnt++] = nums[i++];
     *         }
     *         while (j <= r) {
     *             tmp[cnt++] = nums[j++];
     *         }
     *         for (int i = 0; i < r - l + 1; ++i) {
     *             nums[i + l] = tmp[i];
     *         }
     *
     *
     *          最终是将 tmp 的赋值给原数组
     */

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
