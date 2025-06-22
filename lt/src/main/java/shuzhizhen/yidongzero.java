package shuzhizhen;

import java.util.Arrays;

public class yidongzero {
    public void moveZeroes(int[] nums) {
        // 一个遍历指针 一个待替换指针 实际上是第一个0的位置 非0的相对位置不变，0移动到后面去了。
//        1. 待替换指针 实际上是第一个0的位置
        // 比如极端的 1234500 待替换的指针也就是第一个0的指针，第一个0的指针一直变，直到遇到0
        // 极端的 00012345


        // 2.非0相对位置不变 从前往后 找非0挪到前面去！把0挪到后面去 == 把非0挪到前面去！

        // 遇到双指针 移动问题 思路：

        // 1） 一个遍历指针，控制循环遍历 这个几乎不用考虑；一个待替换指针。

        // 2）遍历顺序。 2.1 要么从前往后，要么从后往前。 2.2 此时考虑 替换指针遇到0与非0怎么处理待替换指针。

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 3. 0的相对位置不变。

    public void moveZeroes2(int[] nums) {

        int j = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 2.1 首先定方向：从后往前。2.2 其次， 思考 待替换指针 遇到 0与非0的处理
            // 遇到非0 待替换指针不动 等着被替换。遇到0待替换指针跟着变！
            if (nums[i] == 0) {
                swap(nums, i, j);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        yidongzero y = new yidongzero();
        int[] nums = {0, 1, 0, 3, 12};
        y.moveZeroes2(nums);
        // arrays.tostring() 用来打印数组
        System.out.println(Arrays.toString(nums));
    }

}
