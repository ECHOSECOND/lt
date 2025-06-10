package hash;

import java.util.HashMap;
import java.util.Map;

public class zuichanglianxuxulie {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * @param nums
     * @return
     */
    // 最长连续序列
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            numsMap.put(num, num);
        }
        // 最长 可以考虑 从左边界找起
        // 遍历数组，如果 元素-1存在说明 不是左边界 直接跳过，不然作为左边界去找连续序列
        for (int num : nums) {
            if (numsMap.containsKey(num - 1)) {
                // 有更小的左边界 跳过
                continue;
            }
            int count = 0;
            // 作为左边界 持续找连续序列
            for (int index = num; numsMap.containsKey(index); index++) {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
