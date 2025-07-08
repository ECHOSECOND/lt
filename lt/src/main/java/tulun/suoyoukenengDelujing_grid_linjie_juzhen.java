package tulun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class suoyoukenengDelujing_grid_linjie_juzhen {

    private List<List<Integer>> res = new ArrayList();
    private List<Integer> path = new ArrayList();
    private boolean[] visited;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        /**
         * 这里通过邻接矩阵来表明 图节点关系， 邻接矩阵 占据空间大一些 是 new int[graph.length][graph.length]
         */
        int[][] graph2 = new int[graph.length][graph.length];

        // 2. 采用邻接矩阵的方式
        for (int i = 0; i < graph.length; i++) { // 第一层是各个节点
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    graph2[i][graph[i][j]] = 1;
                }
            }
        }

        // 2. graph2[x][j]=1表明相连
        allPathsSourceTarget0(graph2, 0);
        return res;

    }

    private void allPathsSourceTarget0(int[][] graph2, int index) {

        /**
         * 3. graph2[x]是x这个节点 跟其它节点的关系，grid[x][y]=1的表明x、y相连
         */

        int[] indexTos = graph2[index]; // 其它节点的关系与x的关系
        for (int i = 0; i < indexTos.length; i++) {
            int orther = indexTos[i]; // 传orther为1死循环 继续传1 进去 一直是1
            if (graph2[index][i] == 1) { // 如果 i =1 意味着该节点i与x 链接了。加入到path继续递归。
                path.add(i);
                if (i == graph2.length - 1) {
                    res.add(new ArrayList(path));
                }
                allPathsSourceTarget0(graph2, i); // 传i
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        suoyoukenengDelujing_grid_linjie_juzhen suoyoukenengDelujing2 = new suoyoukenengDelujing_grid_linjie_juzhen();
        System.out.println(Arrays.deepToString(suoyoukenengDelujing2.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}).toArray()));
    }

}

