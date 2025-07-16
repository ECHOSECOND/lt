package zhan_he_duilie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class dui_qianKge_gaopin_yuansu {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();

        /**
         * 优先级队列（PriorityQueue）默认是升序排列（最小堆），因此每次调用 poll() 会移除并返回当前队列中的最小元素
         */

        // 1. 自定义优先级队列 队列里面放element 包含元素和次数 两个内容
        PriorityQueue<Element> queue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                // 升序
                return o1.count - o2.count;
            }
        });



        // 2. 遍历一遍数组，将元素以及出现次数放到map中

        for (int num : nums) {
            countMap.put(num, countMap.computeIfAbsent(num, (key) -> 0) + 1);
        }
        // 遍历map 添加到优先级队列

        // 3. 遍历map 将Element 组装放到对列。
        // 前k个元素就是 如果size>k 就poll 可以把次数最少的 poll出来。此时 k个是最大的k的元素。

        for (Map.Entry<Integer, Integer> ele : countMap.entrySet()) {
            // 逐个加入超出了就pop
            queue.add(new Element(ele.getValue(), ele.getKey()));
            // 升序
            // 移除的会是最小次数的元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int index = 0;
        for (Element element : queue) {
            result[index++] = element.val;
        }
        return result;

    }

    class Element {
        int count;
        int val;

        public Element(int count, int val) {
            this.count = count;
            this.val = val;
        }
    }
}
