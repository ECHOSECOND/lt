package putongshuzu;

import java.util.Arrays;

public class lunzhuanshuzuandshuzuyiwei {


    // 2. 原地实现翻转的方法
    // 先整体翻转 然后分段翻转。 整体相当于 i、j为 0、nums.length-1
    // 所以写一个数组 范围 [i,j] 翻转的方法即可。
    public void rotate1(int[] nums, int k) {
        // 观察规律
        // 1 2 3 4 5 6 7
        // 先全部反转
        // 7 6 5 4 3 2 1
        // 0-2 反转-> 5 6 7 4 3 2 1
        // 3-length-1 反转 -> 5 6 7 1 2 3 4
        // 这里的2 是 (k-1)%nums.length

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, (k - 1));
        reverse(nums, k, nums.length - 1);
    }

    // 数组 范围 [i,j] 翻转的方法即可
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 轮转数组 就是旋转数组 旋转后的部分 其实还是保持有序的！！

    public void rotate2(int[] nums, int k) {
        // 借助一个数组 实现翻转
        // nums[i] 的值赋给 newnums[(i+1)%len]
        int[] newNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // 1. 注意这种方法就是 旋转数组或者触发数组的位移 需要给新数组赋值。 newNums[x] = nums[i]（原数组）
            newNums[(i+k)%nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

        System.out.println(Arrays.toString(newNums));
    }

    public static void main(String[] args) {
        lunzhuanshuzuandshuzuyiwei lunzhuanshuzuandshuzuyiwei = new lunzhuanshuzuandshuzuyiwei();
        lunzhuanshuzuandshuzuyiwei.rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

}
