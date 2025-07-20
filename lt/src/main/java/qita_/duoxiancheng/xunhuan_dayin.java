package qita_.duoxiancheng;

public class xunhuan_dayin {
    /**
     * 多线程 循环打印10次,分别打印ABC
     */

    // 几个线程靠一把锁协同
    private static Object lock = new Object();

    // 几个线程协同的
    private static int num = 0;


    // 两者写法均可！！主要是注意 获取到锁 是从await处继续执行，不是 重新来一遍for循环！

    public static void printNum2(int loop, int targetNum, String print) {

        synchronized (lock) {

            for (int i = 0; i < loop; i++) {

                // 注意一定是 while 不满足条件睡眠。 唤醒后， 继续进入while
                // while和睡眠在一起 方便二次检查、进入二次睡眠！！
                while (num % 3 != targetNum) { // 当条件不满足时等待

                    // 不能用if！！
                    // 虚假唤醒导致错误执行：
                    //
                    //如果线程被虚假唤醒，会直接跳过条件检查，继续执行后续代码。
                    //
                    //可能打印错误的字符或操作错误的数据。

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

                System.out.println(print);
                num++;
                lock.notifyAll();
            }

        }
    }


    public static void printNum(int loop, int targetNum, String print) {

        for (int i = 0; i < loop; i++) {
            synchronized (lock) {

                // 注意一定是 while 不满足条件睡眠。 唤醒后， 继续进入while
                // while和睡眠在一起 方便二次检查、进入二次睡眠！！
                while (num % 3 != targetNum) { // 当条件不满足时等待

                    // 不能用if！！
                    // 虚假唤醒导致错误执行：
                    //
                    //如果线程被虚假唤醒，会直接跳过条件检查，继续执行后续代码。
                    //
                    //可能打印错误的字符或操作错误的数据。

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

                System.out.println(print);
                num++;
                lock.notifyAll();
            }

        }


    }

    public static void main(String[] args) {
        new Thread(() -> {
            printNum(10, 0, "A");
        }).start();

        new Thread(() -> {
            printNum(10, 1, "B");
        }).start();

        new Thread(() -> {
            printNum(10, 2, "C");
        }).start();
    }

}
