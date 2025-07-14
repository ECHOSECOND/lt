package dongtaiguihua.huiwen_zichuan;

public class zuichang_huiwenchuan_zhongxin_tuozhan {
    /**
     * 通过中心拓展法，双指针拓展
     * <p>
     * 找到中点 如果奇数双指针是mid
     * <p>
     * 如果偶数是 双指针是mid-1和mid
     */

    public String longestPalindrome(String s) {
        return longestPalindromeByZhongxinTuozhan(s);
    }

    private String longestPalindromeByZhongxinTuozhan(String s) {
        if (s.length() <= 1) return s;
        String longestPalindrome = "";

        //

        for (int i = 0; i < s.length(); i++) {
            // 必须同时检查奇数和偶数中心 否则可能漏掉！！
            // aba 和 abba
            // 是每一个位置 向两边扩散！！！
            String longestPalindrome1 = findLongestPalindromeByZhongxinTuozhan(s, i, i);
            String longestPalindrome2 = findLongestPalindromeByZhongxinTuozhan(s, i, i+1);
            String largerPalindrome = longestPalindrome1.length() > longestPalindrome2.length() ? longestPalindrome1 : longestPalindrome2;
            longestPalindrome = largerPalindrome.length()>longestPalindrome.length()?largerPalindrome:longestPalindrome;
        }

        return longestPalindrome;
    }

    private String findLongestPalindromeByZhongxinTuozhan(String s, int left, int right) {
        String longestPalindrome = "";
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > longestPalindrome.length()) {
                    longestPalindrome = s.substring(left, right + 1);
                }
                left--;
                right++;
            } else {
                return longestPalindrome;
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        zuichang_huiwenchuan_zhongxin_tuozhan zhongxinTuozhan = new zuichang_huiwenchuan_zhongxin_tuozhan();
        System.out.println(zhongxinTuozhan.longestPalindrome("babad"));
    }

}
