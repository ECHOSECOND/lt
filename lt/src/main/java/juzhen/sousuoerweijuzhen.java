package juzhen;

public class sousuoerweijuzhen {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. 思路以最右上角元素为比较基准
        // 同样先定义行和列
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0; // i是第一行
        int j = n - 1;// j是最后一列； 也就是 最右上角元素。
        // 3. 条件 i<=行结束 j<=列结束
        while (i >= 0 && i <= m - 1 && j >= 0 && j <= n - 1) {
            if (matrix[i][j] == target) {
                return true;
            }
            // 2. 比target大的 左移 也就是 j--
            // 比target小的，下移i++
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
