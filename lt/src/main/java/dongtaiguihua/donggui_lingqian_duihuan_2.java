package dongtaiguihua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class donggui_lingqian_duihuan_2 {

    private List<Integer> path = new ArrayList<>();
    private int count = 0;

    int[][] memo;

    public int change(int amount, int[] coins) {
        // 1. 回溯的思想 每一枚硬币 可选、可不选 两种情况 平铺去写
//        return changeByHuisu1(amount, coins);

        // 2. 回溯思想优化 记忆存储

        memo=new int[coins.length+1][amount+1];

        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
//        return changeByHuisuJiyi(amount, coins);

        // 3. 也可以回溯标准的for循环写法。

        return changeByHuisuJiHe(amount, coins);
    }

    private int changeByHuisuJiHe(int amount, int[] coins) {
        return changeByHuisuJiHe(coins, 0, amount);
    }

    private int changeByHuisuJiHe(int[] coins, int start, int remaining) {
        if (remaining == 0) return 1;
        if (remaining < 0) return 0; // 注意小于也要返回0！！！！

        // 记忆化解决的是子问题重复计算，与排列/组合无关 组合已经没有重复去选择了！ 除了自身

        /**
         * coins=[1,2,3], amount=4：
         *
         * text
         * dfs(0,4)
         * ├─ 选1: dfs(0,3)
         * │   ├─ 选1: dfs(0,2)
         * │   │   ├─ 选1: dfs(0,1)
         * │   │   │   └─ 选1: dfs(0,0) → 1 (1+1+1+1)
         * │   │   └─ 选2: dfs(1,0) → 1 (1+1+2)
         * │   └─ 选2: dfs(1,1)
         * │       └─ 选1: dfs(1,0) → 1 (1+2+1) ✘ 重复
         * └─ 选2: dfs(1,2)
         *     ├─ 选2: dfs(1,0) → 1 (2+2)
         *     └─ 选3: dfs(2,-1) → 0
         */

        if (memo[start][remaining] != -1) return memo[start][remaining];

        int total = 0;
        for (int i = start; i < coins.length; i++) {
            if (coins[i] <= remaining) {
                // 注意可以重复选！！
                total += changeByHuisuJiHe(coins, i, remaining - coins[i]);
            }
        }

        // 记忆数组 最后设置值！！！
        memo[start][remaining] = total;
        return total;
    }

    private int changeByHuisuJiyi(int amount, int[] coins) {

        return changeByHuisuJiyi(amount, coins, 0,0);

    }

    private int changeByHuisuJiyi(int amount, int[] coins,int curTotal, int index) {

        if (memo[index][curTotal] != -1) {
            return memo[index][curTotal] ;
        }

        if (index == coins.length) {
            // 看看是不是符合预期
            if (curTotal == amount) {
                return 1;
            }
            return 0;
        }


        int total=0;

        // 选择
        if (curTotal+coins[index]<= amount) {

            // 注意可以重复选！！所以 这里是index！！

            total+=changeByHuisuJiyi(amount, coins,curTotal+coins[index], index);
        }

        // 不选
        total+=changeByHuisuJiyi(amount, coins,curTotal, index + 1);

        memo[index][curTotal]=total;
        return total;

    }




    private int changeByHuisu1(int amount, int[] coins) {

        change(amount, coins, 0);
        return count;

    }

    private void change(int amount, int[] coins, int index) {
        if (index == coins.length) {
            // 看看是不是符合预期
            if (pathSum(path) == amount) {
                count++;
            }
            return;
        }

        // 选择
        if (pathSum(path) < amount) {
            path.add(coins[index]);

            // 注意可以重复选！！所以 这里是index！！

            change(amount, coins, index);
            path.remove(path.size() - 1);
        }

        // 不选
        change(amount, coins, index + 1);

    }

    private int pathSum(List<Integer> path) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        donggui_lingqian_duihuan_2 d = new donggui_lingqian_duihuan_2();
        System.out.println(d.change(5, new int[]{1, 2, 5}));
    }

}
