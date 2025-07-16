package zhan_he_duilie;

import java.util.Stack;

public class panduan_zhan {


    public static void main(String[] args) {
        panduan_zhan p = new panduan_zhan();
        System.out.println(p.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    /**
     * 验证栈
     */

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 不需要两个栈
        // 一个栈压入的时候 看弹出序列是否与它相等
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            // 注意 stack.peeek 的时候 需要判断 !stack.isEmpty
            while (j<popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
