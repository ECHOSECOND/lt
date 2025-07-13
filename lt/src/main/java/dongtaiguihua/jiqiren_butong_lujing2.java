package dongtaiguihua;

public class jiqiren_butong_lujing2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 1. 有障碍

        // 2. 起点或者终点为障碍 直接返回0

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // 3. 初始化
        // 第一行

        // 注意只要第一行某个位置出现 1 不满足for循环条件， 立马终止初始化，初始化默认都是0

        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        // 第一列
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        // 4.遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        jiqiren_butong_lujing2 butong = new jiqiren_butong_lujing2();
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(butong.uniquePathsWithObstacles(obstacleGrid));
    }

}
