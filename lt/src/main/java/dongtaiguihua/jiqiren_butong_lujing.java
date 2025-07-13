package dongtaiguihua;

public class jiqiren_butong_lujing {

    private int count;

    private boolean[][] visited;

    public int uniquePaths(int m, int n) {

        // 图遍历
//        return uniquePathsByDfs(m, n);

        // 动态规划
        return uniquePathsByDongtaiGuihua(m,n);

    }

    private int uniquePathsByDongtaiGuihua(int m, int n) {
        // 1. 定义dp dp[i][j] 为从00到i、j的路径数

         int[][] dp = new int[m][n];

         // 2. 确定递推公式
        // dp[i][j] = dp[i][j-1]+dp[i-1][j] 从左边和上边过来

        // 3. 初始化 第一行 第一列都是1
        // 所有行，也就是第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 所有列 也就是第一行
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        //4. 遍历顺序 从左上角开始
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        //5. 最终返回 右下角
        return dp[m-1][n-1];


    }

    private int uniquePathsByDfs(int m, int n) {

        /**
         * 1.这棵树的深度其实就是m+n-1（深度按从1开始计算）。
         *
         * 那二叉树的节点个数就是 2^(m + n - 1) - 1
         *
         * 深搜代码的时间复杂度为O(2^(m + n - 1) - 1)，
         *
         * 2. m、n是 行、列； i、j从0开始 需要与m-1，n-1比较。
         *
         *
         */

        visited =new boolean[m][n];

        // 图/多叉树的遍历。

        // 这其实是路径问题，只不过不涉及路径path的收集，路径问题

        // 1.有向无环图和树的路径 不需要visted！！！因为不会走原来的！！路径问题需要path回溯。

        // 2.但是图遍历可能走原来的节点！需要visted！！除非岛屿问题改了原数组值，可能起到了 visted的作用

        // 3. 图+路径 需要visted+path组合！！这里不需要 路径 不需要path那就只需要visted

        // 从左上角开始遍历
        uniquePathsByDfs(m, n,0,0);
        return count;
    }

    private void uniquePathsByDfs(int m, int n, int i, int j) {
        // 遇到了边界
        if (i > m-1 || j > n-1) {
            return;
        }
//        if (visited[i][j]) {
//            return;
//        }
        visited[i][j] = true;
        if (i == m-1 && j == n-1) {
            // 走到了右下角
            count++;
            // return    // 不要return 不然没法撤销了！！不要阻止撤销操作！！
        }
        // 向右
        uniquePathsByDfs(m,n,i,j+1);
        // 向下
        uniquePathsByDfs(m,n,i+1,j);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        jiqiren_butong_lujing lujing = new jiqiren_butong_lujing();
        System.out.println(lujing.uniquePaths(3,7));
    }


}
