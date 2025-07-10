package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class quan_pai_lie_test_xiezai_limian {
    // 定义节点是否被选择
    boolean[] choosed;
    // 定义选择的路径
    List<Integer> path = new ArrayList();
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        choosed = new boolean[nums.length];
        path = new LinkedList<>();
        permute0(nums);
        return res;
    }

    private void permute0(int[] nums) {



        // 4. 全排列可以选重复的 所以这里是 从0开始遍历。组合 i从 start/pos（递归函数传入）开始

        for (int i = 0; i < nums.length; i++) {

            // 2. 全排列逻辑写在里面 外层基本不需要写递归结束条件

            if (choosed[i]) {
                continue;
            }

            path.add(nums[i]);
            choosed[i] = true;
            if (path.size() == nums.length) {
                res.add(new ArrayList(path));

                // 1. 不要阻断回溯！

            }

            // 3.回溯 特别是 从集合选择（要用到for循环）可以这么想：

            // 每次递归调用都是嵌套的for循环！！！，第一次 选0 递归调用：

            // 嵌套的for循环，排除掉0 只能循环1、2；选1

            // 继续嵌套的for循环，选2； 不能再选了，剔除掉 2；

            // 回到上一层 上一次选的1 ，这次选2.。依次类推

            // 选完 1、2 外层选0的第一次结束，选1，继续递归调用。

            permute0(nums);

            choosed[i] = false;
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        quan_pai_lie_test_xiezai_limian test = new quan_pai_lie_test_xiezai_limian();
        List<List<Integer>> result= test.permute(new int[]{1, 2, 3});
        System.out.println(Arrays.deepToString(result.toArray()));
    }


}
