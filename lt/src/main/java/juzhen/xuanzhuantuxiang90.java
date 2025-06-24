package juzhen;

public class xuanzhuantuxiang90 {
    public void rotate(int[][] matrix) {
        // 一般遍历一半 j从i开始
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                // 1. 先翻转矩阵，按照对角线翻转。 本质上是交换：i,j 和j,i 交换
                // 只需要遍历对角线即可。不然交换完又重置了！
                // 上三角就是j从i+1开始，不然i=j，类似 （1，1）没有交换的意义
                // 下三角就是 j 从0开始到 i-1
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 2. 然后将所有行翻转一遍
        // 翻转每一行
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    // 3. 翻转行 相当于 翻转一个一维数组， 按照 start，end的区间进行翻转即可。 两个指针要 ++和--
    public void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void rotate2(int[][] matrix) {
        // 旋转90度 需要先按照中心线反转
        // 然后反转每一行
        // 1. 按照中心线反转 i,j 与 j,i 交换，只操作一半，对于每一行i而言，j从i开始。
        if(matrix.length ==0) return;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<=i-1;j++){
                int val = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = val;
            }
        }

        // 2. 反转每一行
        for(int i=0;i<matrix.length;i++){
            // i 表示改行
            reverse(matrix[i]);
        }

    }

    public void reverse2(int[] row){
        // 每行只操作一半即可
        for(int i=0;i<row.length/2;i++){
            int val = row[i];
            row[i] = row[row.length-1-i];
            row[row.length-1-i]=val;
        }
    }
}
