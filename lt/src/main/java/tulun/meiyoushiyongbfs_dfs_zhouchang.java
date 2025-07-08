package tulun;
import java.util.*;

public class meiyoushiyongbfs_dfs_zhouchang {

        // 每次遍历到1，探索其周围4个方向，并记录周长，最终合计
        // 声明全局变量，dirs表示4个方向
        static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 统计每单个1的周长
        static int count;

        // 探索其周围4个方向，并记录周长
        public static void helper(int[][] grid, int x, int y) {

            // 2. 4个节点 如果是边界或者是水 说明 x、y是边 可以 count++

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 遇到边界或者水，周长加一
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length
                        || grid[nx][ny] == 0) {
                    count++;
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 接收输入
            int M = sc.nextInt();
            int N = sc.nextInt();

            int[][] grid = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int result = 0; // 总周长
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {
                        // 1. 思路 遇到陆地 就去看周边四个节点
                        count = 0;
                        helper(grid, i, j);
                        // 更新总周长
                        result += count;
                    }
                }
            }

            // 打印结果
            System.out.println(result);
        }
}
