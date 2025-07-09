package tulun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class kecheng_biao {
    /**
     * 1. 能不能完成 实际上看的是 图有没有环
     *
     * 2. 有向无环图的遍历 不会造成 重复元素，本质上是 类似多叉树，不用使用 visted 数组
     *
     * 3. 拓扑排序就是 将图中的节点按照依赖关系，排序出现的顺序，将其依次放到结果集中。最终看结果集的个数=全部数目说明 遍历完了，没有环
     *
     *  拓扑排序 需要先构建图【可以用 数组链表法（嵌套的list）】以及构建入度
     */

    // 1）嵌套的list构建图
    List<List<Integer>> graph = new ArrayList();


    // bfs思想 入度 图拓扑排序

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList());
        }

        // numCourses是课程数
        // prerequisites是课程依赖关系 也就是 可以设置方向 1，0 表示 0->1 的方向

        // 2）. 先构建图，同时计算各个节点的入度

        int[] indegrees = new int[numCourses];

        // prerequisites依赖关系，类似 from to的概念。或者说线的概念， right和left 分别定义了 from和to

        // 所以通过 线的依赖关系，from、to的关系 可以构建出 图。graph.get(index) 去add toNodes

        // 入度 通过 indegrees 来定义， indegrees[index节点] 的入度 = n;

        for (int i = 0; i < prerequisites.length; i++) {
            int[] herf = prerequisites[i];
            int from = herf[1];
            int to = herf[0];
            indegrees[to]++;
            List<Integer> herfs = graph.get(from);
            herfs.add(to);
        }

        // 3）找到入度为0的节点第一个入队；也可能有多个。 这也是 初始化 queue的过程。
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count =0;

        while (!queue.isEmpty()) {
            count++;
            int i = queue.poll();
            // 找到节点的相邻子节点
            for (int son : graph.get(i)){
                // 本节点入队 给其它字节点入度-1
                indegrees[son]--;
                // 字节点入度=0 入队

                // 4） 入队条件
                if (indegrees[son]==0){
                    queue.add(son);
                }
            }
        }

        // 图构建完后 方便后面 找到某个点的 相邻节点。也就是子节点

        // graph中 list的下标就是图中的节点编号

        return count == numCourses; // 相同说明无环 证明能完成
    }

}
