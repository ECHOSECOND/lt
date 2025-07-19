package huisu;

import java.util.ArrayList;
import java.util.List;

public class kuohao_shengcheng {

    List<String> res = new ArrayList<>();

    List<String> path = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        /**
         * 1. 二叉树的递归遍历也是回溯。 只不过 选择了当前节点后 只能有两种选择，left和right
         *
         * 2. 回溯本身就是多叉树的递归遍历，二叉树是其中一种
         *
         * 3. 当只有两种选择时 可以用 二叉树的 回溯模版来写！！
         *
         * 4. 二叉树都是 一黑到最左侧，然后一点点回退。下面解释了跟二叉树不完全一样。
         */

        generateParenthesis(n, n);
        return res;

    }

    private void generateParenthesis(int left, int right) {

        if (left == 0 && right == 0) {
            StringBuilder builder = new StringBuilder();
            for (String ele : path) {
                builder.append(ele);
            }
            res.add(builder.toString());
            return;
        }


        // 递归条件写在里面 的回溯写法
        if (left > 0) {
            path.add(String.valueOf("("));
            generateParenthesis(left - 1, right);
            path.remove(path.size() - 1);
        }

        // 比 right>0 更严格！
        if (right > left) {
            path.add(String.valueOf(")"));
            generateParenthesis(left, right - 1);
            path.remove(path.size() - 1);
        }

        // 以n=2为例：

        /**
         *         ""
         *        /   \
         *      "("    ×（剪枝，因为初始 close=0 ≮ open=0）
         *     /   \
         *   "(("  "()"
         *   /      / \
         * "(()"  "()("
         *  /       /
         * "(())" "()()"
         *
         * 不像二叉树递归到最左侧 其left和right都为空了
         *
         * 需要将本节点回溯，进而去操作 父节点的右节点
         *
         * 这里递归到 “最左侧” (( 需要将右侧加进来 变为 (() 和 (())
         *
         * 然后回溯 ( 时是先将 )) 回溯去除掉
         */


    }

    public static void main(String[] args) {
        kuohao_shengcheng kuohao = new kuohao_shengcheng();
        kuohao.generateParenthesis(3);
        System.out.println(1);
    }

}
