package zhan_he_duilie;

import java.util.Comparator;
import java.util.PriorityQueue;

public class dui_qianK_zuida_yuansu {
    public int findKthLargest(int[] nums, int k) {
        // 维护长度为k的优先级队列

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int num : nums) {
            minHeap.add(num);
            // 优先级队列 每次poll的是最小的或者最大的

            // 核心就是当 size大于k时弹出 保证是生序的 且是前k个元素！！
            // 不需要考虑窗口问题，要将元素移除窗口
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        dui_qianK_zuida_yuansu d = new dui_qianK_zuida_yuansu();
        System.out.println(d.findKthLargest(nums, 2));
    }

}
