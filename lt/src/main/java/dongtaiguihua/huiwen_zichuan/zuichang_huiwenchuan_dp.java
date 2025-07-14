package dongtaiguihua.huiwen_zichuan;

public class zuichang_huiwenchuan_dp {
    /**
     * 动规的想法跟 动规求回文串的个数一样，只不过在判断 [i,j] 为回文串的情况下
     *
     * 看看此时 i,j 是不是最长的 即可
     *
     * 也就是本质上都是求 回文子串问题！！！
     *
     */

    public String longestPalindrome(String s) {
        return longestPalindromeByDp(s);
    }

    private String longestPalindromeByDp(String s) {

        /**
         * 1. 我们虽然是一个输入，字符串的形式。可以 通过 区间[i,j] 来定义 二维dp数组
         */

        // 1. 定义 dp[i,j] 为 i,j 区间是否为回文串，j>=i的如果是的话 定义一个 count进行++

        // 也就是定义 i,j 为区间 进而引出 二维dp

        // 2. 推导
        // dp[i][j] 在s[i]==[j]时，分为三种情况 i=j是回文串
        // j-i=1 两个字符且相同 是回文串
        // j-i>1 dp[i][j] 由子问题推导而来 dp[i+1][j-1]

        // 3. 从推导来看， dp[i][j]依赖dp[i+1][j-1]，需要从下到上。从左到右。
        // 最子的结果是 dp[0][s.length-1]

        // 4. 初始化 都初始化为默认的false
        int m = s.length();

        int count = 0;

        String longest = "";

        boolean[][] dp = new boolean[m][m];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 来得到是不是回文串。 只不过这里只是统计个数
                    if (i==j){
                        dp[i][j] = true;
                    }
                    if (j-i==1){
                        dp[i][j] = true;
                    }
                    if (j-i>1){
                        dp[i][j] = dp[i+1][j-1];
                    }
                    // 在判断是回文串的情况下 看 j-i+1长度是否超了res
                    if (dp[i][j]){
                        if (j-i+1>longest.length()){
                            longest = s.substring(i, j+1);
                        }
                        count++;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        zuichang_huiwenchuan_dp dp = new zuichang_huiwenchuan_dp();
        String longest = dp.longestPalindrome("babad");
        System.out.println(longest);
    }

}
