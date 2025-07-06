package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zuhe {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        for (int i = 1; i <= n; i++) {
            combine(i, n, k);
        }
        return result;
    }

    private void combine(int start, int end, int k) {

        // 1.递归条件写在前面 既然不会选 自然就不用撤回 回溯。
        // 就跟二叉树root==null 写在前面一样。

        if (start > end) {
            return;
        }
        /**
         * 写在一起
         */

        // 2.既然选了 撤回一定要执行 不要被递归条件阻挡

        // 3. 加入元素，然后判断 基本同时出现的！！

        // 4.以上写法就跟 回溯、图遍历一样的了！
        path.add(start);
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
        }
        for (int i = start; i <= end; i++) {
            combine(i + 1, end, k);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        zuhe z = new zuhe();
        System.out.println(Arrays.deepToString(z.combine(4, 2).toArray()));
    }
}
