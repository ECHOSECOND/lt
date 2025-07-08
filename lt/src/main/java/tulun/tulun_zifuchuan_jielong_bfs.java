package tulun;
import java.util.*;

public class tulun_zifuchuan_jielong_bfs {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.nextLine();
            String beginStr = scanner.next();
            String endStr = scanner.next();
            scanner.nextLine();
            List<String> wordList = new ArrayList<>();
            wordList.add(beginStr);
            wordList.add(endStr);
            for (int i = 0; i < n; i++) {
                wordList.add(scanner.nextLine());
            }
            int count = bfs(beginStr, endStr, wordList);
            System.out.println(count);
        }

        /**
         * 广度优先搜索-寻找最短路径
         */
        public static int bfs(String beginStr, String endStr, List<String> wordList) {
            int len = 1;
            Set<String> set = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            visited.add(beginStr);
            q.add(beginStr);
            q.add(null);
            while (!q.isEmpty()) {
                String node = q.remove();
                //上一层结束，若下一层还有节点进入下一层

                // 1. 这里是 用null来区分层 我们完全可以通过 queue.size 来穷尽这一层 看下面的bfs2

                if (node == null) {
                    if (!q.isEmpty()) {
                        len++;
                        q.add(null);
                    }
                    continue;
                }
                char[] charArray = node.toCharArray();
                //寻找邻接节点
                for (int i = 0; i < charArray.length; i++) {
                    // 2. 记录旧值，用于回滚修改
                    char old = charArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        charArray[i] = j;
                        String newWord = new String(charArray);

                        // 3. 用字典包含来确定是不是相连的子节点，如果 相连 加入到queue
                        // 也就是不用非得通过 grid[x] 取x的 toNodes 或者 grid[x][y] 是否有链接


                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            q.add(newWord);
                            visited.add(newWord);
                            //找到结尾
                            if (newWord.equals(endStr)) return len + 1;
                        }
                    }
                    charArray[i] = old;
                }
            }
            return 0;
        }

}
