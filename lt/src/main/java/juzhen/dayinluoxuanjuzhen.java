package juzhen;

import java.util.ArrayList;
import java.util.List;

public class dayinluoxuanjuzhen {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        // 1. 定义行数和列数

        int row = matrix.length;
        int column = matrix[0].length;

        // 2. 定义四个边界。

        int top = 0;
        int right = column - 1;
        int left = 0;
        int bottom = row - 1;

        // 3. while条件是没有将所有元素遍历完。 res.size <= 矩阵元素个数
        while (res.size() < row * column) {
            // 最上面的行开始从左到右

            // 4. 从上、右、下、左 这样的顺序来遍历。

            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            }
            if (right >= left) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if (bottom >= top) {
                for (int i = right; i >= left; i--) { // 注意下 是从右到左 --
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) { // 注意左 从下到上 也是 --
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList();
        // 定义四个边界
        int top=0;int bottom = matrix.length-1;int left=0;int right = matrix[0].length-1;

        while(res.size()<matrix.length*(matrix[0].length)){
            // 从上
            if(top<=bottom){
                for(int i=top;i<=right;i++){
                    res.add(matrix[top][i]);
                }
                top++;
            }
            // 从右
            if(right>=left){
                for(int i=top;i<=bottom;i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            // 往左
            if(bottom>=top){
                for(int i=right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 往上
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }
        return res;
    }
}
