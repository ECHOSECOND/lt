package tulun;

import java.util.*;

public class youxiangtu_kedaxing {

    /**
     * 这个也不是路径问题 相当于是遍历 看看从开始节点能不能遍历 所有节点。
     *
     * 也需要visited！！避免重复访问 形成环 死循环
     *
     * visited记录了访问过的节点 如果 visited 访问了 全部节点，说明完全可达！
     *
     * 相当于是从起点搜索 全部节点， 岛屿都是 从 某个节点/陆地 去搜索
     *
     */

    public static List<List<Integer>> adjList = new ArrayList<>();

    public static void dfs(boolean[] visited, int key) {
        // 递归终止条件 -- 处理逻辑写在循环外面
        if (visited[key]) {
            return;
        }
        visited[key] = true;
        List<Integer> nextKeys = adjList.get(key);
        for (int nextKey : nextKeys) {
            dfs(visited, nextKey);
        }
    }

    public static void bfs(boolean[] visited, int key) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(key);
        visited[key] = true;
        while (!queue.isEmpty()) {
            int curKey = queue.poll();
            List<Integer> list = adjList.get(curKey);
            for (int nextKey : list) {
                if (!visited[nextKey]) {
                    queue.add(nextKey);
                    visited[nextKey] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices_num = sc.nextInt();
        int line_num = sc.nextInt();
        for (int i = 0; i < vertices_num; i++) {
            adjList.add(new LinkedList<>());
        }//Initialization
        for (int i = 0; i < line_num; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            adjList.get(s - 1).add(t - 1);
        }//构造邻接表
        boolean[] visited = new boolean[vertices_num];
        dfs(visited, 0);
//        bfs(visited, 0);

        // 所有节点是否可达！
        for (int i = 0; i < vertices_num; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }
}
