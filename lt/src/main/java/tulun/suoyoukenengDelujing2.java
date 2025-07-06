package tulun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class suoyoukenengDelujing2 {

    private List<List<Integer>> res = new ArrayList();
    private List<Integer> path = new ArrayList();
    private boolean[] visited;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

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
        int[] indexTos = graph2[index];
        for (int i = 0; i < indexTos.length; i++) {
            int orther = indexTos[i]; // 传orther为1死循环 继续传1 进去 一直是1
            if (graph2[index][i] == 1) {
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
        suoyoukenengDelujing2 suoyoukenengDelujing2 = new suoyoukenengDelujing2();
        System.out.println(Arrays.deepToString(suoyoukenengDelujing2.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}).toArray()));
    }

}

