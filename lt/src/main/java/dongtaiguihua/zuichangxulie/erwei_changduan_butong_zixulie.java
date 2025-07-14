package dongtaiguihua.zuichangxulie;

import java.util.ArrayList;
import java.util.List;

public class erwei_changduan_butong_zixulie {
    /**
     * 1. 对于公共子序列等问题 不涉及长短、转换 无所谓 行m、列n取 哪个序列
     * <p>
     * 2. 对于涉及到序列转换问题。 需要长序列控制m 短序列控制n
     * <p>
     * 画二维图表现也是 左侧是长序列 上侧为短序列。
     * <p>
     * 第一个格子是 "" 和 ""
     */

    int count = 0;
    private List<String> path = new ArrayList<String>();

    public int numDistinct(String s, String t) {

        // 1. 回溯求组合的思想 求所有满足长度的子序列
//        return numDistinctByHuiSu(s, t);

        // 2. dp
        return numDistinctByDp(s, t);
    }

    private int numDistinctByDp(String s, String t) {

        // 1. s为长序列， m行 为长序列 n列为 短序列

        int m = s.length();
        int n = t.length();

//        dp[i][j] = 用s的前i-1个字符匹配t的前j-1个字符的方法数

        int[][] dp = new int[m + 1][n + 1];
        // 两者都为空字符 可以相互转换为1
        dp[0][0] = 1;

        // 第一行除了0，0 均为0

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        // 第一列除了0，0 均为1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }

//        int result = 0;

        // 2. 一般分为 s[m] 与t[n] 相等与不相等两种情况来讨论

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // bagg与bag为例
                    // dp[i - 1][j - 1] 表明用了i、j元素 m、n都缩短下，g用了，看bag和ag
                    // dp[i - 1][j]表示没有用长序列的元素g，看长序列上一个序列。看bag与bag
                    // 如果是 dp[i][j-1] 看bagg 和 ag； 相当于 t少了一个字符，dp[i][j-1]表示跳过t的第j个字符，这与子序列匹配的要求（必须匹配t的所有字符）
                    // 我们要求s要匹配t的所有字符！！！所以 t不能少，即 不能是 j-1！！只能是i-1

                    // i代表长序列，j代表短序列
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                // 注意这里 用max的方法是错误的：

                //  s 中完全匹配 t 的子序列数量， 如果取中间过程， t还不是完整的子序列 就用于匹配计算了！

//                result = Math.max(result, dp[i][j]);
            }
        }

        return dp[m][n];

    }

    private int numDistinctByHuiSu(String s, String t) {
        // 寻找s长度为t.length的子序列
        numDistinctByHuiSu(s, 0, t, t.length());
        return count;
    }

    private void numDistinctByHuiSu(String s, int index, String t, int length) {
        if (path.size() >= length) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // 1. char 转string 用 String.valueOf
            path.add(String.valueOf(s.charAt(i)));
            if (path.size() == length) {
                // 2. list<String> 可以用String.join 分隔
                String xulie = String.join("", path);
                if (xulie.equals(t)) {
                    count++;
                }
            }
            numDistinctByHuiSu(s, i + 1, t, length);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        erwei_changduan_butong_zixulie b = new erwei_changduan_butong_zixulie();
        b.numDistinct("rabbbit", "rabbit");
        System.out.println(b.count);
    }
}
