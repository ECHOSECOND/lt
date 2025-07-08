package tulun;

public class zongjie_dfs {
    /**
     *
     1. 如果不是路径问题（如只需要访问所有节点或判断连通性）：

     visited 仅用于避免重复访问，不需要回溯。

     例如：图的遍历、拓扑排序、连通分量计算。

     2. 如果是路径问题（如需要记录完整路径或所有可能路径）：

     visited 和 path 都需要回溯（否则后续路径无法访问已走过的节点）。

     例如：全排列、迷宫所有路径、单词搜索 II。

     但是 都需要 visited！！

     3.岛屿问题（如统计岛屿数量、最大岛屿面积）属于非路径问题，通常只需要遍历所有连接的陆地单元格（'1'），而不需要记录具体路径。因此：

     关键结论
     不需要回溯 visited：只需标记已访问的单元格（如将 '1' 改为 '0'），防止重复访问。

     不需要维护 path：无需记录路径，只需统计数量或面积。


     两种写法，一种明确要写 递归条件；回溯逻辑for循环外面

     一种递归逻辑写在 for 循环里面

     // 写法一：处理当前访问的节点 处理逻辑写在外面 需要递归条件
     void dfs(const vector<list<int>>& graph, int key, vector<bool>& visited) {
        if (visited[key]) {
          return;
         }
         visited[key] = true;
         list<int> keys = graph[key];
         for (int key : keys) {
             // 深度优先搜索遍历
         dfs(graph, key, visited);
     }
     }

     // 写法二：处理下一个要访问的节点， 处理逻辑写在循环里面。
     void dfs(const vector<list<int>>& graph, int key, vector<bool>& visited) {
        list<int> keys = graph[key];
        for (int key : keys) {
            if (visited[key] == false) { // 确认下一个是没访问过的节点
            visited[key] = true;
            dfs(graph, key, visited);
          }
        }
     }

     */
}
