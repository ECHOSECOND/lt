package huisu;

public class danci_sousuo {

    private boolean[][] visited;
    private boolean finded = false;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {

                    // 注意这里是从 index=0开始搜索！！！因为 i、j是从 board[i][j] == word.charAt(0) 处开始的！！

                    exist(board, i, j, m, n, 0, word);
                }
            }
        }
        return finded;
    }

    private void exist(char[][] board, int i, int j, int m, int n, int index, String word) {
        if (index >= word.length()) {
            finded = true;
            return;
        }
        if (i>=m || i<0 || j>=n || j<0) {
            return;
        }

        // 不是有向无环图 需要 不走重复的 在一条路径上。

        if (visited[i][j]) {
            return;
        }

        if(word.charAt(index)!=board[i][j]){
            return;
        }

        visited[i][j] = true;

        // 上下左右搜索
        exist(board, i + 1, j, m, n, index + 1, word);
        exist(board, i - 1, j, m, n, index + 1, word);
        exist(board, i, j + 1, m, n, index + 1, word);
        exist(board, i, j - 1, m, n, index + 1, word);

        // 回溯路径的节点可以重复用。
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        danci_sousuo d = new danci_sousuo();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        d.exist(board, "ABCCED");
    }

}
