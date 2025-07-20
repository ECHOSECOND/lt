package qita_.gaopinti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class hebing_qujian {
    // 如果按照右区间排序 会形成：1.3  2.5 2.4 7,8 1,10
    // 这样 会形成 1，5；7，8；1，10 三个区间
    // 所以按照左边界排序

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[intervals.length][2];
        // 先把第一个加进来
        res[0] = intervals[0];
        int index = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = res[index - 1];
            int[] now = intervals[i];
            // 如果有重叠 上一个区间的 right>=当前区间的left
            if (prev[1] >= now[0]) {
                // 右边界取大的
                prev[1] = Math.max(now[1], prev[1]);
            } else {
                // 新区间
                res[index] = now;
                index++;
            }
        }
        int[][] final_res = new int[index][2];
        for (int i = 0; i < index; i++) {
            final_res[i] = res[i];
        }
        return final_res;
    }

    /**
     * 当然也可以用 list这种写法
     */

    public int[][] merge2(int[][] intervals) {

        // 最多不重复空间 是按照right排序
        // 这里合并区间 按照left排序
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
            int[] lastInterval = result.get(result.size() - 1);
            int[] interval = intervals[i];
            // 不重叠
            if (interval[0] > lastInterval[1]) {
                result.add(interval);
            } else {
                // right取两个区间最大值
                int right = Math.max(interval[1], lastInterval[1]);
                lastInterval[1] = right;
            }
        }
        // 2. int[] 是可以直接作为范型的
        return result.toArray(new int[result.size()][]);
    }

}
