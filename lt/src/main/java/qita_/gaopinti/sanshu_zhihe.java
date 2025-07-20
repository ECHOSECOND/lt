package qita_.gaopinti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sanshu_zhihe {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 三数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 1.先排序
        Arrays.sort(nums);

        // 这里可以是 nums.length-2 留出两个元素 不然没法算做三数
        for (int i = 0; i < nums.length - 2; i++) {
            int now = nums[i];
            // 要看 i+1-nums.length-1范围有没有两数
            int target = 0 - now;

            // 排序+不要重复的，但是本身集合元素存在重复，一定记得去重！！！！ nums[i]和nums[i-2]
            if(i>=1 && nums[i]==nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int  sum = nums[left] + nums[right];
                if (sum == target) {
                    //找到
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);

                    // 有可能有重复的left、right
                    // 有可能有重复的left、right

                    // 标准的去重写法 ++ left 和 --right
                    while (left< right && nums[left] == nums[++left]) {
                    }
                    while (left < right && nums[right] == nums[--right]) {
                    }

                } else if (sum>target) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }

}
