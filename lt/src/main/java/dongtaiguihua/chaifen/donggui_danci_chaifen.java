package dongtaiguihua.chaifen;

import java.util.ArrayList;
import java.util.List;

public class donggui_danci_chaifen {

    private boolean res;

    private List<String> path = new ArrayList<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        // 回溯和动规 两种写法。
//        return wordBreakByHuiSu(s, wordDict);

        return wordBreakByDp(s, wordDict);

    }

    private boolean wordBreakByDp(String s, List<String> wordDict) {

        /**
         * 不使用背包思想了，，，，， 只有 不重复选取的 可以用 0-1 背包思想来解
         *
         * 这种能不能凑起来 1. 如果不可重复可以用背包思想
         *
         * 2. 重复的或者直接按照 拆数思想，从1到字符串/数字n 去遍历。i
         *
         * 第二层针对 j从0、1 遍历 寻求的是j到i范围是不是 也是两半：j 和 i-j
         */

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        // 1. 跟拆分数字、拆分完全平方数一样。 都是 i从1到n，对于每个i而言，从0到i！！！
        for (int i=1;i<=s.length();i++){
            // 对于i而言， 0到i 看如果前面已经满足了 看后面是否满足
            for (int j=0;j<i;j++){
                // j从0，i； j-i的字符串如果匹配 且dp[j] 也就是前面的已经匹配了
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean wordBreakByHuiSu(String s, List<String> wordDict) {
        // 从集合/字符串中选择
        wordBreakByHuiSu(s, wordDict, 0);
        return res;
    }

    private void wordBreakByHuiSu(String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            // 检查path的size 是否和s相同
            StringBuilder builder = new StringBuilder();
            for (String ele : path) {
                builder.append(ele);
            }
            if (builder.toString().equals(s)) {
                res = true;
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String ele = s.substring(index, i+1);
            if (wordDict.contains(ele)) {
                path.add(ele);
                wordBreakByHuiSu(s, wordDict, i + 1);
                path.remove(path.size()-1);
            }
        }
    }



}
