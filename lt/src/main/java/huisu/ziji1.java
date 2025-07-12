package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ziji1 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsetsAgain(nums);
        System.out.println(Arrays.deepToString(res.toArray()));
        return res;
    }


    // 再写一遍
    public List<List<Integer>> subsetsAgain(int[] nums) {
        // 1. 首先数组元素是不重复的。不需要单独去重

        // 2. 元素不能重复用。那么类似 嵌套for循环的 循环start要从i+1开始。 这样天然不会重复利用,递归函数要有index

        // 3. 不是到达某个长度才会add 只要选择了就往结果 加

        res.add(new ArrayList<>());

        subsetsAgain(nums, 0);
        return res;
    }

    private void subsetsAgain(int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            // 5. 不需要路径满足长度再去add
            res.add(new ArrayList<>(path));
            // 4. 天然去重 不需要再通过状态位判断 嵌套的for循环
            subsetsAgain(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        ziji1 z = new ziji1();
        z.subsets(new int[]{1, 2, 3});
    }

}
