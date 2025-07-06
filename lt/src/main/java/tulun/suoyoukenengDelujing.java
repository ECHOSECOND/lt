package tulun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class suoyoukenengDelujing {

    private List<List<Integer>> res = new ArrayList();
    private List<Integer> path = new ArrayList();
    private boolean[] visited;

    /**
     * 1. 数组+链表的方式
     * @param graph
     * @return
     */

    /**
     * 有向无环图 遍历 跟遍历二叉树一样求路径。只不过 子节点/目标节点【多叉树】有多个。
     * for循环递归。
     * 两种：循环内写回溯逻辑；循环外写回溯逻辑，注意写递归结束条件，回溯逻辑不要被递归打断！往往 在最外层递归调用处也要循环。
     * 排列那种集合回溯，本质上也是多叉树
     *
     * 都可以想成多叉树， 处理完节点后 要回溯的！！
     *
     * 回溯【集合/排列】、二叉树递归路径（带回溯）、图遍历 本质都是多叉树
     *
     * 二叉树只不过是 铺开了 递归过程！！因为只有left、right；其它的要靠循环去递归。
     *
     * @param graph
     * @return
     */

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        // * 例如： [[1,2],[3],[3],[]] 数组元素的个数 节点数，数组下标代表起始节点 from，
        // 下标对应的值 表明 起始节点到对应的值to1..toN
//        path.add(0);

        visited = new boolean[graph.length];
        allPathsSourceTarget(graph, 0);
        return res;
    }

    private void allPathsSourceTarget(int[][] graph, int index) {
        // 2. 有向无环图 理论上这里不会走到。 也就是这里的递归条件可以没有。
        if (visited[index]) {
            return;
        }
        path.add(index);
        visited[index] = true;

        // 1. 必须要到达最后一个节点 -> index == graph.length - 1，最后一个节点的 [] 为空

        if (index == graph.length - 1) { // 4. 跟全路径问题里面判断 root.left==null && root.rght==null 一样的效果
            res.add(new ArrayList<>(path));
        }

        // 3. 这里的for循环节点的to节点，就跟 二叉树 去递归 left、right 两个节点一样
        // 我们用跟二叉树一样的写法 处理完所有节点后 再回溯撤销

        int[] toNodes = graph[index];
        for (int i = 0; i < toNodes.length; i++) {
            allPathsSourceTarget(graph, toNodes[i]);
        }
        visited[index] = false;
        path.remove(path.size() - 1);

    }


    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {

        // * 例如： [[1,2],[3],[3],[]] 数组元素的个数 节点数，数组下标代表起始节点 from，
        // 下标对应的值 表明 起始节点到对应的值to1..toN
//        path.add(0);

        visited = new boolean[graph.length];

        // 5. 无论哪种方法 入口只有一个，不像 组合问题 入口有多个。

        path.add(0);
        allPathsSourceTarget2(graph, 0);
        return res;
    }

    /**
     * 4. 另一种写法 写在循环里面
     * @param graph
     * @param index
     */
    private void allPathsSourceTarget2(int[][] graph, int index) {

        int[] toNodes = graph[index];
        for (int i = 0; i < toNodes.length; i++) {

            path.add(toNodes[i]);
            visited[toNodes[i]] = true;
            if (toNodes[i] == graph.length - 1) {
                res.add(new ArrayList<>(path));
            }

            allPathsSourceTarget2(graph, toNodes[i]);

            visited[toNodes[i]] = false;
            path.remove(path.size() - 1);

        }

    }


    public static void main(String[] args) {
        suoyoukenengDelujing sol = new suoyoukenengDelujing();
        List<List<Integer>> res = sol.allPathsSourceTarget2(new int[][]{{1, 2}, {3}, {3}, {}});
        System.out.println(Arrays.deepToString(res.toArray()));
    }

}
