package hash;

public class twosum1 {

    /**
     * 1. 两数之和
     * 已解答
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 提示
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum0(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(numsMap.containsKey(target-num)){
                // 这是之前的数字
                result[0] = numsMap.get(target-num);
                result[1]= i;
                break;
            }
            numsMap.put(num, i);
        }
        return result;
    }

    // 这种是可能会有多个答案的
    public int[] twoSum(int[] nums, int target) {
        // 遍历到i 往前看 通过 containsKey() 判断的便是 i 与 [0,i-1] 所有的数字的关系 一一判定。也就是本质上还是 穷尽了两两关系
        // 只不过 这种穷尽 是从后面往前看，后面的元素与前面所有元素的对应 且 利用 hashmap 使得效率提高
        List<List<Integer>> allRes = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (posMap.containsKey(target - nums[i]) && !used[i] && !used[posMap.get(target - nums[i])]) {
                List<Integer> res = new ArrayList<>();
                res.add(posMap.get(target - nums[i]));
                res.add(i);
                used[i] = true;
                used[posMap.get(target - nums[i])] = true;
                allRes.add(res);
            }
            posMap.put(nums[i], i);
        }
        List<Integer> result = allRes.get(0);
        int[] arr = new int[2];
        arr[0] = result.get(0);
        arr[1] = result.get(1);
        return arr;
    }
}
