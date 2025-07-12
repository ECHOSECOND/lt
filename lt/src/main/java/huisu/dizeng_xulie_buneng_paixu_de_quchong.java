package huisu;

import java.util.*;

public class dizeng_xulie_buneng_paixu_de_quchong {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> findSubsequences(int[] nums) {

        // 1. 我们从集合中找符合条件的数，每次 path一定是 add 一个 ele，之后 remove 掉

        findSubsequences(nums, 0);

        return res;
    }

    private void findSubsequences(int[] nums, int index) {

        // 3. 去重。

        // 以 1 2 2 3 4 5 为例 树枝是 1->2->2->3->4->5, depth一直在增加，每一层depth都会产生一个新的set 传入下一层 所以 不会有影响选择 1->2->2

        // 树层是 选择了 1 后，从 2-5 集合去选。2-5选择了2 从3-5 继续以此类推，最终回到选择1的循环，此时 depth=0
        // 相当于是同层，即 1、2、2、3、4、5 同层可以用set把第二个2 去掉。

        Set<Integer> set = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                continue;
            }

            // 2. 遍历集合，如何判断是否符合条件，当前i比前面的大就行

            if (path.size()==0 || (path.size() > 0 && nums[i] >= path.get(path.size() - 1))) {
                path.add(nums[i]);
                set.add(nums[i]);
                if (path.size()>=2){
                    res.add(new ArrayList<>(path));
                }
                findSubsequences(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        dizeng_xulie_buneng_paixu_de_quchong x = new dizeng_xulie_buneng_paixu_de_quchong();
        x.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(Arrays.deepToString(x.res.toArray()));
    }

}
