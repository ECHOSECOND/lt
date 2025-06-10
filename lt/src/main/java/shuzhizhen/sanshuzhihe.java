package shuzhizhen;

import java.util.*;

public class sanshuzhihe {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     */

    public List<List<Integer>> threeSum(int[] nums) {
        // 排序 并且 避免使用重复元素 已经保证了最终的各个结果是不重复的
        // 对于排序的数组 计算两树之和 可以用 双指针的方式
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 由于数组有序 使用双指针
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    result.add(res);
                    // 为了避免 -2 -2 4 4 这种重复元素
                    while (left < right && nums[left] == nums[++left])
                        ;
                    while (left < right && nums[right] == nums[--right])
                        ;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        // 我们无论寻找两数还是三数，都是 i 的位置 往后找 这样保证不重复。 三个数
        // 先排序 然后使用 双指针的方法
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复计算
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 我们寻找三个数之和=0，寻找的过程为了避免重复，也是 一个固定后，从后面的序列找另外两个。 所以 left=i+1
            // 演变为 寻求target
            int target = -nums[i];
            // 有序数组寻找和为target，注意 从 i往后找
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    // 先添加到结果
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[++left])
                        ;
                    while (left < right && nums[right] == nums[--right])
                        ;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 固定i 去看 数组i之后所有元素是否符合情况
            // 固定i 只需要看 i-nums.length-1 区间的就行。 因为 i之前的x在 固定 x的时候就已经看过了，已经从x后面的元素列表找过了！
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, -nums[i]);
            for(List<Integer> sumRes :  twoSumRes){
                sumRes.add(nums[i]);
            }
            result.addAll(twoSumRes);
        }
        return result;
    }

    // 两数之和
    // 利用map的思想
    public List<List<Integer>> twoSum(int[] nums, int pos, int target) {
        // 遍历到i 往前看 通过 containsKey() 判断的便是 i 与 [0,i-1] 所有的数字的关系 一一判定。也就是本质上还是 穷尽了两两关系
        // 只不过 这种穷尽 是从后面往前看，后面的元素与前面所有元素的对应 且 利用 hashmap 使得效率提高
        List<List<Integer>> allRes = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = pos; i < nums.length; i++) {
            // used用于避免重复选择index
            if (posMap.containsKey(target - nums[i]) && !used[i] && !used[posMap.get(target - nums[i])]) {
                List<Integer> res = new ArrayList<>();
                res.add(target - nums[i]);
                res.add(nums[i]);
                used[i] = true;
                used[posMap.get(target - nums[i])] = true;
                allRes.add(res);
            }
            posMap.put(nums[i], i);
        }
        return allRes;
    }
}
