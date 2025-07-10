package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class quan_pai_lie {
    // 定义节点是否被选择
    boolean[] choosed;
    // 定义选择的路径
    List<Integer> path = new ArrayList();
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        choosed = new boolean[nums.length];
        path = new LinkedList<>();
        //. 递归
        // 入口有多个
        for (int i = 0; i < nums.length; i++) {
            permute0(nums, i);
        }
        return res;
    }

    private void permute0(int[] nums, int pos) {
        if (choosed[pos]) {
            return;
        }

        // 2. 实际逻辑。
        //      path.add(nums[pos]);
        //        choosed[pos] = true;
//        if (path.size() == nums.length) {
//            res.add(new ArrayList(path));
//        }
        // 同时出现



        path.add(nums[pos]);
        choosed[pos] = true;
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
        }
        // 选择

        // 1. 全排列逻辑写在外层，for循环内部基本只写 递归逻辑！！

        for (int i = 0; i < nums.length; i++) {
            permute0(nums, i);
        }

        // 3. 不要让递归逻辑阻断回溯！！

        choosed[pos] = false;
        path.remove(path.size() - 1);
    }


}
