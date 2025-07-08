package tulun;

public class tulun_bfs {
    /**
     * 1. bfs可以图中解决从 A节点到B节点的最短路径
     *
     * 2. 在图遍历时，图中绝大多数 BFS 问题都需要 visited
     * 树遍历（无环）可以忽略 visited，择机加入其 左右子节点即可
     * visited 是为了避免节点重复访问。
     *
     * 3. 啥时候 往访问过的节点集合 添加元素？ visited
     *
     * 如果在 queue.poll() 之后才标记 visited：
     *
     * String curr = queue.poll();
     * if (!visited.contains(curr)) {  // ❌ 延后检查
     *     visited.add(curr);
     *     // 处理逻辑...
     * }
     *
     * 可能会造成
     *
     * 如果多个节点的邻接节点相同（如 A → C 和 B → C），不立即标记 visited 会导致 C 被多次加入队列。
     *
     * 例如：
     *
     * text
     * Queue: [A, B]
     * A 访问 C → 未标记 visited，C 入队
     * B 访问 C → 未标记 visited，C 再次入队
     * 最终 Queue: [C, C]  // 重复处理！
     *
     * 所以需要 往队列里加时 立马进行标记！！！！ 而不是 从队列里 poll出来了 再标记
     *
     * 即：
     *
     *     String curr = queue.poll(); // 当前节点
     *     for (String neighbor : getNeighbors(curr)) { // 子节点
     *         if (!visited.contains(neighbor)) { // 不包含时 才加，避免重复入队！！！
     *             queue.offer(neighbor);
     *             visited.add(neighbor);  // ✅ 防止重复入队
     *         }
     *     }
     */
}
