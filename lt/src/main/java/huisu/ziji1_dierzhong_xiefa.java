package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ziji1_dierzhong_xiefa {
    private List<Integer> path;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        path = new LinkedList<>();
        res.add(new ArrayList<>());
        //. 递归
        // 入口有多个
        for (int i = 0; i < nums.length; i++) {
            permute0(nums, i);
        }
        return res;
    }

    private void permute0(int[] nums, int pos) {

        // 1. 主要逻辑写在 外面的 这样需要写递归结束条件
        if (pos >= nums.length) {
            return;
        }
        // 同样还是每个pos有选择列表的机会 不过pos只选择比起位置更大的元素
        // 比如 0 会选择1、2；选择 1时，1也有选择机会只能选择 2； 1选完后 结束递归。 0会接着选择 2，2只能选择自己了。 接着是 1 开始选，1选择 2；
        // 2 只能选择自己
        // 这样每个元素只能选择比自己大的元素 这样就不会造成重复。 不会 1 2 3 和 2 1 3 这种出现
        // 每个元素选择完 所有列表后 撤销选择 【也就是选择和撤销选择在for循环外】
        path.add(nums[pos]);
        res.add(new ArrayList<>(path));
        // 选择

        // 2. 这样递归写在循环里面 基本很少的逻辑了。
        for (int i = pos; i < nums.length; i++) {
            permute0(nums, i + 1);
        }

        // 3. 当前节点处理完的撤销。

        // 可以二叉树采用写在外面的写法，排列、集合 等写在循环内部！！！

        path.remove(path.size() - 1);
    }
}
