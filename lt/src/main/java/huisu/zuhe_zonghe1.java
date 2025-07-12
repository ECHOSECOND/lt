package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zuhe_zonghe1 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1.注意还是组合问题 只不过当前元素i可以被重复使用

        combinationSum(candidates, target, 0,0);

        return res;
    }

    private void combinationSum(int[] candidates, int target, int total,int index) {
        if (total>target){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            total+=candidates[i];
            path.add(candidates[i]);
            if (total == target) {
                res.add(new ArrayList<>(path));
            }
            combinationSum(candidates, target, total, i);
            path.remove(path.size()-1);
            total-=candidates[i];
        }
    }

    public static void main(String[] args) {
        zuhe_zonghe1 z = new zuhe_zonghe1();
        List<List<Integer>> res =z.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(Arrays.deepToString(res.toArray()));
    }

}
