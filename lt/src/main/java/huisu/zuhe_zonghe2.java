package huisu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剪枝是性能优化，去重是保证结果正确。
 * <p>
 * 1. 最基本的组合问题， 集合元素不重复， 元素不重复使用。 两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 组合问题 顶多是 当前元素i可以重复使用。也就是传递给下一层的是i还是i+1
 * <p>
 * 而排列问题，是对于当前元素i而言，之前的都可以用。所以 循环是从0开始的！！
 * <p>
 * 2. 求和。集合元素不重复，可能当前元素能重复用/可能不能重复用。 但是要求组合不能重复，所以 下一次循环是从 i 跟i+1，天然组合不会重复
 * <p>
 * 3. 求和。集合元素重复，能/不能重复用（无非是i还是i+1）。即使不重复使用i+1的模式，但可能还是有重复组合。需要去重。
 * <p>
 * 这里去重 通过 used[i-1] = false
 * <p>
 * <p>
 * 排列： 集合遍历从0开始。
 * <p>
 * 组合：从i开始（当前元素重复用），从i+1当前元素不重复用。
 * <p>
 * 在这个背景下，集合元素可能有重复/不重复的情况。
 */
public class zuhe_zonghe2 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    // 集合元素可能重复 ，元素不能重复使用的情况【组合】
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0); // 这里的0就是index 为了避免重复选取的
        return res;
    }

    private void combinationSum2(int[] candidates, int target, int total, int index) {
        // 递归写在for循环内的 可以终止条件写在外。
        if (total > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 2.这里去重/剪枝 通过used

            // 注意去重 像 1 2 2 3 4 只不过2不再参与选择，不要影响3、4 所以是continue
            // 主要像同一个树枝上 1 2 2 不会影响 此时 used[i-1] = true 这种不用continue！

            // 4. 注意 i-1 要使用 需要i>=1
            if (i >= 1 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            // 3. 拉满 used、totol、path 以及其回溯。 注意图一定需要used 但是 回溯在组合情况下 已经不会重复使用 大多不会用到used 只不过这里要去重！
            used[i] = true;
            total += candidates[i];
            System.out.println(total);
            path.add(candidates[i]);

            if (total == target) {
                res.add(new ArrayList<>(path));
            }

            // 1.因为我们天然通过 i+1的方式实现了 元素的不重复选取
            combinationSum2(candidates, target, total, i + 1);

            used[i] = false;
            total -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        zuhe_zonghe2 z = new zuhe_zonghe2();
        List<List<Integer>> res = z.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(Arrays.deepToString(res.toArray()));
    }
}
