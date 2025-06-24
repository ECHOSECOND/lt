package juzhen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class juzhenzhiling {
    public void setZeroes(int[][] matrix) {

        // 思路1 是记录 行或者列 是否包含0 将行、列 号 记录下来。
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // 记录行和列
                    zeroRows.add(i);
                    zeroColumns.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRows.contains(i) || zeroColumns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    /**1. 第一行 (matrix[0][j]) 用于标记某一列是否需要置零。

     第一列 (matrix[i][0]) 用于标记某一行是否需要置零。
     *
     *
     * 2.为什么不能从 (0, 0) 开始遍历？
     *
     * 如果从 (0, 0) 开始遍历，当遇到 matrix[0][j] = 0 或 matrix[i][0] = 0 时，会直接修改第一行或第一列的标记位。
     *
     * 这样会导致后续的标记错误，因为第一行和第一列的原始信息会被覆盖。
     * @param matrix
     */

    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        // 第一行是否有零
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }
        }
        // 第一列是否有零
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }
        }
        // 把第一行第一列作为标志位

//        0,1,2,0
//        3,4,5,2
//        1,3,1,5

        // 1. 注意不能直接从0开始遍历设置 因为 0,1,2,0 在处理第一行时 将第一行全改成0了。这样后面的行遍历时
        // 因为参考 该列的第0个位置 都已经变成0了 所以会跟着变0导致错误改动
        // 第一行第一列是要变成0 但是是最后的时候设置为0 不要一开始就遍历它改它各列为0，会影响其它行各列！


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置0
        // 所以这里遍历 打算置0 的时候 不要从 0,0 开始。
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 2. 到最后单独处理第一行和第一列。如果 前面1 处理了第一行 第一列 作为标识位 会影响其他行的。

        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        juzhenzhiling juzhenzhiling = new juzhenzhiling();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        juzhenzhiling.setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

}
