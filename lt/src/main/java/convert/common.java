package convert;

import java.util.*;

public class common {
    public static void main(String[] args) {


        // 1. 常用的数据结构与转换
        // list 转array
        List<String> list = new ArrayList<String>();
        // 也就是 list.toArray (new xx[list.size])
        list.toArray(new String[list.size()]);

        // 2. Arrays.stream()
        // Arrays.sort
        // Arrays.tostring

        // 3. array和list转换。
        // 将array转list
        // Arrays.asList()

        // 4.打印list
        // List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        // String result = String.join(", ", list);

        // string转数组
        String str = "apple,banana,orange,grape";
        String[] array = str.split(",");

        // 输出验证
        // System.out.println(Arrays.toString(array));
        // 输出: [apple, banana, orange, grape]

        // string转list
        String str2 = "java,python,c++,javascript";
        List<String> list2 = Arrays.asList(str2.split(",")); // Arrays.asList 转list！！！
        System.out.println(list);


        // 5. 使用 LinkedList 实现 队列和栈
//        操作	队列实现	栈实现
//        添加元素	addLast() (队尾)	addLast() (栈顶)
//        移除元素	pollFirst() (队首)	pollLast() (栈顶)
//        查看元素	peekFirst() (队首)	peekLast() (栈顶)
//         添加都是 addLast 队列弹出 pollFirst 栈弹出 pollLast

        // 6. 栈stack push和pop
        Stack<String> stack = new Stack<String>();
        // 栈用push和pop！！
        stack.push("a");
        stack.pop();


        // 7.PriorityQueue 优先级队列的 add 和 peek poll
        PriorityQueue pq = new PriorityQueue();
        // 入队和出队
        pq.add(list);
        System.out.println(pq.poll());
    }
}
