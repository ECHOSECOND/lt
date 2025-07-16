package zhan_he_duilie;

import java.util.Stack;

public class zhan_zifuchuan_jiema {

    private Stack<StringBuilder> strStack = new Stack<>();
    private Stack<Integer> numStack = new Stack<>();

    public String decodeString(String s) {

        // 3. 注意 prevStr 不仅仅包括[ 之前的字符串。 还会包括进入[后要循环的字符串
        // 因为进入[ 后,prevStr 被压入栈 清空了。 这样就 只用于循环了。
        StringBuilder prevStr = new StringBuilder();
        StringBuilder preNum = new StringBuilder();

        // 思路： 1. 遇到 [ 就进行 push 遇到 ] 就进行pop

        // 用stringbuildder和数字记录，遇到[时就可以把记录过的之前的字符串和数字给取出来

        // 2. 字符串和数字分别用一个栈

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                preNum.append(c);
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                prevStr.append(c);
                continue;
            }
            if (c == '[') {

                // 4. 遇到[压入栈清空 压入栈的部分用于 未来作为 prev 拼接。可理解递归函数进入之前上下文的压栈
                // 新积累起来的 prevStr 用于 遇到 ] 后循环用的。 prevStr 用做了两个作用。

                strStack.push(prevStr);
                // 重置
                prevStr = new StringBuilder();
                preNum = new StringBuilder();

                // 数字作为字符串，通过如下方式可以计算真正的数值
                int num = 0;
                for (int j = 0; j < prevStr.length(); j++) {
                    num = num * 10 + prevStr.charAt(j) - '0';
                }
                numStack.push(num);
                continue;
            }
            if (c == ']') {
                // 遇到[ 之前的字符串
                StringBuilder prevPart1 = strStack.pop();
                int loop = numStack.pop();
                for (int k = 0; k < loop; k++) {
                    // prevStr是遇到[后， ]前累计的
                    prevPart1.append(prevStr);
                }
                // 将整个结果重新赋值给prevStr

                // 相当于一个完整的 xx数字[] 结束了。 要将其重置为prevStr 方便下一个]到来要循环它。
                // 也就是 [] 内的内容
                // 如 输入：s = "3[a2[c]]" 第一次a2[c] 结束了，要将 “accacc” 作为prevStr供下一个]到来时去循环，然后与[之前的字符串拼接起来
                //输出："accaccacc"
                prevStr = prevPart1;
            }
        }

        return prevStr.toString();

    }

    class pair {
        private String left;
        private Integer right;

        public pair(String left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

}

