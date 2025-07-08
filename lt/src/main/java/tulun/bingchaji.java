package tulun;

public class bingchaji {
    /**
     * 1. 路径压缩
     *
     * 路径压缩的效果： 会将途经的所有节点直接指向根，后续查询只需一步。
     *
     * 具体实现：
     *
     * int find(int u) {
     *     if (u != father[u]) {
     *         father[u] = find(father[u]);  // 递归压缩
     *     }
     *     return father[u];
     * }
     *
     * 注意 如果我们 递归函数 返回的是 传入的 u 那么 这样递归结束了 节点关系都没发生变更。
     *
     * 如果 我们每个递归函数返回的是 递归的返回值，那么 我们 最终递归得到的 是 root 节点
     *
     * 所以 上面其实得到了 跟节点， 在遇到每个 u 时 都把 u的father设置了 根节点。
     *
     *
     */
}
