package tulun.leetcode;

import java.util.Scanner;

public class Daoyu_shuliang {

    private boolean[][] visted; // 标记 避免重复

    public int numIslands(char[][] grid) {
        // 使用 DFS遍历图/多子节点（相邻节点） 遍历过程 将所有经过的点染色
        int count = 0;
        if (grid.length == 0) {
            return count;
        }
        visted = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid.length-1, grid[0].length-1, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int m, int n, char[][] grid) {
        // 类似 树/图 的遍历方式
        // 对i，j的兄弟节点进行遍历 其实跟 递归(root.left)、递归(root.right) 没啥区别

        // 注意：先写边界 不然可能越界！！
        // 类似树写递归终止条件
        if (i > m || i < 0 || j < 0 || j > n) {
            return;
        }

        if (visted[i][j] || grid[i][j] == '0') {
            return;
        }

        visted [i][j] = true;

        // 遍历途中 如果已经处理过 跳过；这里的寓意是 已经被染过色了。 有点类似 visted 标识


        grid[i][j] = '0';

        // 上下左右。 其实你用 for 循环找 节点的四个 相邻节点也是一样的
        dfs(i - 1, j, m, n, grid);
        dfs(i + 1, j, m, n, grid);
        dfs(i, j - 1, m, n, grid);
        dfs(i, j + 1, m, n, grid);
    }

    /**
     * 前面也提到了 如果 逻辑写到 for 循环里面就不用 写递归结束条件了
     */

    public static int[][] dir ={{0,1},{1,0},{-1,0},{0,-1}};
    public static void dfs(boolean[][] visited,int x,int y ,int [][]grid)
    {
        for (int i = 0; i < 4; i++) {
            int nextX=x+dir[i][0];
            int nextY=y+dir[i][1];

            // 逻辑写在里面 包括结束条件、进入递归的条件，这样提前规避了 递归终止

            if(nextY<0||nextX<0||nextX>= grid.length||nextY>=grid[0].length)
                continue;
            if(!visited[nextX][nextY]&&grid[nextX][nextY]==1)
            {
                visited[nextX][nextY]=true;
                dfs(visited,nextX,nextY,grid);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m= sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j]=sc.nextInt();
            }
        }
        boolean[][]visited =new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]&&grid[i][j]==1)
                {
                    ans++;
                    visited[i][j]=true;
                    dfs(visited,i,j,grid);
                }
            }
        }
        System.out.println(ans);
    }

}
