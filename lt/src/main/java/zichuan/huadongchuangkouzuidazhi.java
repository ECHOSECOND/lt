package zichuan;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class huadongchuangkouzuidazhi {
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] windowMax = new int[nums.length - k + 1];

            // 1. 队列： 栈： 方法实现


            // 单调栈使用 双端队列。 双端队列可以用LinkedList 既可以实现队列 又能当作栈 使用
            // LinkedList 作为双端队列时 要直接 使用 LinkedList来声明
            // 如果 LinkedList 不作为先进先出队列
            LinkedList<Integer> queue = new LinkedList();
            // 我们队列里面维护数组的索引，需要时 通过 nums[i] 来取即可！！！
            for (int i = 0; i < k; i++) {
                // 将比当前元素i小的驱逐出去，这样队列里面 就只剩下 比i大的元素、i。
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
            }

            // 注意既然使用了 queue 这种双端队列， 方法最好 peekFirst 这种 不要再使用 peek or poll

            // 不取出！
            windowMax[0] = nums[queue.peekFirst()];

            int index = 1;

            for (int j = k; j < nums.length; j++) {
                // 只保留比 nums[i] 大的
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[j]) {
                    queue.pollLast();
                }
                queue.addLast(j);
                // 可能队列多个最大值都已经不在当前窗口 需要依次弹出！！
                while (queue.peekFirst() <= j - k) {
                    queue.pollFirst();
                }
                windowMax[index] = nums[queue.peekFirst()];
                index++;
            }
            return windowMax;
        }

        public int[] maxSlidingWindow1(int[] nums, int k) {
            int[] windowMax = new int[nums.length - k + 1];
            // 解法一 使用优先级队列 降序

            // 2. 优先级队列 add 和 peek、poll

            // 3. 真正的栈方法？

            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
                }
            });
            for (int i = 0; i < k; i++) {
                // 队列每个元素 记录值和坐标index
                queue.add(new int[] {nums[i], i}); // 4. new int【】和  new int【】{}
            }
            windowMax[0] = queue.peek()[0];
            int index = 1;

            for (int j = k; j < nums.length; j++) {
                queue.add(new int[] {nums[j], j});
                // 有可能队列里面的最大值已经在窗口之外，要将其移除
                while (queue.peek()[1] <= j - k) {
                    queue.poll();
                }
                windowMax[index] = queue.peek()[0];
                index++;
            }
            return windowMax;
        }
    }
}
