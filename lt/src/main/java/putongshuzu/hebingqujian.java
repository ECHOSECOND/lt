package putongshuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class hebingqujian {
    static class Solution {
        public int[][] merge(int[][] intervals) {

            // 最多不重复空间 是按照right排序
            // 这里合并区间 按照left排序

            // 1. 注意不能按照右边排序，因为排序是全局视角。 比如
//            {1, 3},
//            {2, 6},
//            {8, 10},
//            {1, 18}

            // 的例子，最终是要返回 {1,18} 的， 如果 按照右边界排序，可能导致 1，18排在最后面。

            // 导致前面的区间 合并 比如 第一次合并得到 1，6 后 与 8，10 合并 依然为 1，6 ；8，10 ；导致1，18跟8，10合并 最终返回了两个区间

            // 比如 [1,7] [4,6]
            List<int[]> result = new ArrayList<>();

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // 升序
                    return o1[0] - o2[0];
                }
            });
            result.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] lastInterval = result.get(result.size()-1);
                int[] interval = intervals[i];
                // 不重叠
                if (interval[0]>lastInterval[1]){
                    result.add(interval);
                }else {
                    // 2. right取两个区间最大值。因为 left是排序了的，所以一定是 left更小的！！！
                    int right = Math.max(interval[1], lastInterval[1]);
                    lastInterval[1] =right;
                }
            }
            // 2. int[] 是可以直接作为范型的
            return result.toArray(new int[result.size()][]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {1, 18}
        };
        int[][] sorted = solution.merge(intervals);
        System.out.println(Arrays.deepToString(sorted));
    }

}
