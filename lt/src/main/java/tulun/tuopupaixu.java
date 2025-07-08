package tulun;

import java.util.*;

public class tuopupaixu {
    /**
     * 1. 什么叫拓扑排序
     *
     * 拓扑排序 是将图中 先后依赖/有先后关系的节点列表找出来
     *
     * 将图变为先后依赖顺序的节点列表
     *
     * 就是有向无环图里面 先后执行的节点列表 给找出来 就是拓扑排序
     *
     * 2.一般来说我们只需要掌握 BFS （广度优先搜索）
     *
     * 我们只能将入度为0 的节点0 接入结果集。最终结果集就是节点的先后执行顺序列表
     *
     * 如果我们发现结果集元素个数 不等于 图中节点个数，我们就可以认定图中一定有 有向环！
     *
     *3. 拓扑排序 跟图遍历一样，只不过是有条件的。需要 子节点入度=0
     *
     * 所以 一方面需要 维护图【以数组链表为例，维护节点的后续子节点列表】
     *
     * 另一方面需要 维护度。 节点依赖的节点数量 = 入度数；入度=0的节点执行完 给子节点入度-1
     *
     */

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<List<Integer>> umap = new ArrayList<>(); // 记录文件依赖关系
            int[] inDegree = new int[n]; // 记录每个文件的入度

            for (int i = 0; i < n; i++)
                umap.add(new ArrayList<>());


            // 1. 维护图和入度
            for (int i = 0; i < m; i++) {
                int s = scanner.nextInt();
                int t = scanner.nextInt();
                umap.get(s).add(t); // 记录s指向哪些文件
                inDegree[t]++; // t的入度加一
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                // 2.找到入度=0的节点，可能有多个的！也就相当于 起始节点可能多个！！！这跟之前遍历图一个入口节点不完全一样！
                if (inDegree[i] == 0) {
                    // 入度为0的文件，可以作为开头，先加入队列
                    queue.add(i);
                }
            }

            List<Integer> result = new ArrayList<>();

            // 拓扑排序
            while (!queue.isEmpty()) {
                int cur = queue.poll(); // 当前选中的文件
                result.add(cur);

                // 3. 入度为0的节点 找到其子节点，将其所有入度-1 再将入度=0的子节点入队

                for (int file : umap.get(cur)) {
                    inDegree[file]--; // cur的指向的文件入度-1
                    if (inDegree[file] == 0) {
                        // 4. 入度=0的子节点入队
                        queue.add(file);
                    }
                }
            }

            if (result.size() == n) {
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i));
                    if (i < result.size() - 1) {
                        System.out.print(" ");
                    }
                }
            } else {
                System.out.println(-1);
            }
        }

}
