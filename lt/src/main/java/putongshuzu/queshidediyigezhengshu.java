package putongshuzu;

public class queshidediyigezhengshu {


    public int firstMissingPositive(int[] nums) {
        // 题目要求On 也就是不能嵌套遍历 但是可以 多次 for 循环的！！！
        // 使用空间不要O(n) 说明 可以在原数组上操作。

        // 1. 本来最简单的思路是： 遍历数组 将其放到hash表，然后从1开始遍历 去 hash 表是否存在即可
        // 现在不能借助 hash 表，可以借助原数组。 将nums[i] 放到 i-1的位置。

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 2. i处的值为nums[i] 它应该位于 nums[i]-1 也就是 i要与 nums[i]-1 进行交换
            // 只是注意：
            // 2.1 将i交换后，i的位置来了新的元素！ 要对这个新的元素继续进行交换，直到i处的元素放到它该去的位置，所以 i要-1
            // 2.2 如果 i 已经在了 nums[i]-1的位置，也就是 nums[i]==nums[nums[i]-1] 不需要再交换；不然交换完 比如 1 2；交换完继续处理1会死循环的！
            if (nums[i] >= 1 && nums[i] <= len && nums[i]!=nums[nums[i]-1]) { // 2.1
                // 将nums[i] 放到 nums[i]-1处。 也就是 i 与 nums[i]-1 交换
                swap(nums, i, nums[i] - 1);
                // 替换后记得接着处理下 i 所以这里i--
                i--; // 2.2
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len+1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
