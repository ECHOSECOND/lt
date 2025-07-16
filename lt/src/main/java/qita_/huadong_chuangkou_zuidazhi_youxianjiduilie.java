package qita_;

import java.util.PriorityQueue;

public class huadong_chuangkou_zuidazhi_youxianjiduilie {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return result;
    }
}
