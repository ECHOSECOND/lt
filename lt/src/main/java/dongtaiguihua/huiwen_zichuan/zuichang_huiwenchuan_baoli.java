package dongtaiguihua.huiwen_zichuan;

public class zuichang_huiwenchuan_baoli {
    /**
     * 如何找所有的子串？
     * <p>
     * 本质上是找 字符串两两搭配的位置，也就是 i、j组合 便于去截取字符串
     * <p>
     * 这不就是 回溯求组合的问题。
     * <p>
     * 但是 如果只是 两两组合，那么就是 嵌套的 for循环 即可
     */

    public String longestPalindrome(String s) {
        return longestPalindromeByBaoli(s);
    }

    private String longestPalindromeByBaoli(String s) {
        String longest = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                // 截取i，j 截取不包含right 所以要j+1
                String sub = s.substring(i, j + 1);
                if (isHuiWen(s, i, j)) {
                    if (j - i + 1 > longest.length()) {
                        longest = sub;
                    }
                }
            }
        }
        return longest;
    }

    private boolean isHuiWen(String s, int i, int j) {
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        zuichang_huiwenchuan_baoli baoli = new zuichang_huiwenchuan_baoli();
        String longest = baoli.longestPalindrome("a");
        System.out.println(longest);
    }

}
