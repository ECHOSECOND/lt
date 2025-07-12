package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ziji2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 1.集合元素重复，元素不可以被重复使用

        // 2. 集合元素重复 需要排序+used[i] 去做去重
        used = new boolean[nums.length];
        Arrays.sort(nums);
        subsetsWithDup(nums, 0);

        res.add(new ArrayList<>());

        return res;
    }

    private void subsetsWithDup(int[] nums, int index) {
        if (index > nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 同一树枝上的去重，树层的不去重
            if (i >= 1 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);

            res.add(new ArrayList<>(path));
            subsetsWithDup(nums, i + 1);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        ziji2 z = new ziji2();
        z.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(Arrays.deepToString(z.res.toArray()));
    }

}
