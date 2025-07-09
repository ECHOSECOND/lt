package tulun.leetcode;

public class qianzhui_shu {
    /**
     * 1. 前缀树： 前缀树可以快速判断一个字符串是否存在，或者是否存在以某个前缀开头的字符串，时间复杂度为 O(m)（m 为字符串长度），优于哈希表在某些场景下的表现
     *
     * 2. 大多数单词共享前缀 节省空间
     *
     * 3. 共享前缀的情况：
     *
     *         (根)
     *          |
     *          a
     *          |
     *          p
     *          |
     *          p
     *        / | \
     *       l* e* y*
     *       /     \
     *      e*     *
     *
     *  完全独立的情况：
     *
     *          (根)
     *        / | \
     *       a  b  c
     *       |  |  |
     *       p  p  p
     *       |  |  |
     *       p* p  p
     *          |  |
     *          l  l
     *          |  |
     *          e* y*
     *
     * 4.
     *
     * 深度=字符串长度
     *
     * 节点数 与 共享前缀情况 和 字符串长度 有关
     *
     *
     * 5. 前缀树 就是一个多叉树， 有26个子节点。从root节点开始决定走哪条路径
     *
     * 严格来说 不算图的一部分。算是多叉树的遍历
     *
     *
     */
    class Trie {

        // 2. 前缀树有root节点 作为树结构的入口
        private Node root;

        // 1. 多叉树 有26个子节点
        class Node {
            // 26个子节点

            // 7. 前缀树结构 通过 sign 字符串完整标识，表明是字符串结尾
            // 可以增加 val 字段，表明节点值

            Character val;

            Node[] chirds = new Node[26];
            boolean sign = false;
            public Node(Character val) {
                this.val = val;
            }
        }

        public Trie() {
            root = new Node(null);
        }


        // 4. 插入前缀树
        public void insert(String word) {
            char[] wordChars = word.toCharArray();

            // 3. 多叉树。 从root节点开始看起子节点 children[] 是否存在此字符
            // 存在的话继续从此字符的节点开始找cur。
            // sign标识表示一个完整单词。
            // 注意 每个单词完整路径不一样，不会相互覆盖的！它只会是一个单词的结束标识
            Node cur = root;
            for (int i = 0; i < wordChars.length; i++) {
                char c = wordChars[i];
                // 将该字符插入到Trie树
                if (cur.chirds[c - 'a'] == null) {
                    cur.chirds[c - 'a'] = new Node(c);
                }
                cur = cur.chirds[c - 'a'];
            }
            // 表明这是一个单词的结尾
            cur.sign = true;
        }

        // 5. 前缀树搜索完整字符串
        public boolean search(String word) {
            char[] wordChars = word.toCharArray();
            Node cur = root;
            for (int i = 0; i < wordChars.length; i++) {
                char c = wordChars[i];
                if (cur.chirds[c - 'a'] == null) {
                    return false;
                }
                cur = cur.chirds[c - 'a'];
            }
            return cur.sign;
        }

        // 6. 前缀树搜索单词前缀是否存在。也就是是否存在此前缀的单词。
        public boolean startsWith(String prefix) {
            char[] wordChars = prefix.toCharArray();
            Node cur = root;
            for (int i = 0; i < wordChars.length; i++) {
                char c = wordChars[i];
                // 将该字符插入到Trie树
                if (cur.chirds[c - 'a'] == null) {
                    return false;
                }
                cur = cur.chirds[c - 'a'];
            }
            return true;
        }
    }


}
