package paixu;

import java.util.Arrays;

public class kuaipai {
    public static void main(String[] args) {
        kuaipai kuaipai = new kuaipai();
        int[] nums = new int[]{110,100,0};
        kuaipai.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        // 寻找partition partition所在的值左侧比比较值小 右侧比比较值大
        if (start < end) {
            // 随机一下
            int randomIndex = start + (int)(Math.random() * (end - start + 1));
            swap(nums, randomIndex, end);
            int partition = partition(nums, start, end);
            quickSort(nums, start, partition-1);
            quickSort(nums, partition+1, end);
        }
    }

    public int partition(int[] nums, int start, int end){
        // 选一个比较基值
        int pivot = nums[end];
        // 要让基值左侧比其小 右侧比其大 返回基值所在的位置
        // 定义一个指针指向 大的序列的第一位
        int j = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, i,j);
                j++;
            }
        }
        swap(nums, j, end);
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
