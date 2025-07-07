package tulun;


/**
 * 本质上是遍历、标记（不用消除标记）；
 */
public class daoyudeshuliang {
    public int numIslands(char[][] grid) {
        // 使用 DFS遍历图/多子节点（相邻节点） 遍历过程 将所有经过的点染色
        int count = 0;
        if (grid.length == 0) {
            return count;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 3. 外层只要找到为1的板块就是陆地数量，也就是岛屿数量
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid.length-1, grid[0].length-1, grid);
                }
            }
        }
        return count;
    }

    // 4. 递归虽然传入四个参数 其中两个m、n其实是边界。 本质是 i、j
    private void dfs(int i, int j, int m, int n, char[][] grid) {
        // 类似 树/图 的遍历方式
        // 对i，j的兄弟节点进行遍历 其实跟 递归(root.left)、递归(root.right) 没啥区别

        // 类似树写递归终止条件
        if (i > m || i < 0 || j < 0 || j > n) {
            return;
        }

        // 遍历途中 如果已经处理过 跳过；这里的寓意是 已经被染过色了。 有点类似 visted 标识

        if (grid[i][j] == '0') {
            return;
        }

        // 2. 找到一个为1的陆地 要上下左右遍历 将能拓展的区域都设置为0
        // 或者说是染色的逻辑 我们改变了矩阵原元素的值。
        // 如果不想改变 原矩阵的值 我们可以用 visted数组

        // 类似这样：

        //     if (visited[x][y] || grid[x][y] == 0) return; // 终止条件：访问过的节点 或者 遇到海水
        //    visited[x][y] = true; // 标记访问过；只要遇到陆地 遍历 该节点的所有周边节点 并进行标记。外层没有被标记过的记录陆地岛屿

        grid[i][j] = '0';

        // 上下左右。 其实你用 for 循环找 节点的四个 相邻节点也是一样的

        // 1. 其实图遍历 跟二叉树遍历 没啥区别。 二叉树相当于 left、right两个子节点
        // 图遍历是 toNodes 指向的子节点s 或者 上下左右 四个子节点

        dfs(i - 1, j, m, n, grid);
        dfs(i + 1, j, m, n, grid);
        dfs(i, j - 1, m, n, grid);
        dfs(i, j + 1, m, n, grid);
    }
}
