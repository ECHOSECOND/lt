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
        int mid = s.length() / 2;
        String longestPalindrome = "";

        String longestPalindrome1 = findLongestPalindromeByZhongxinTuozhan(s, mid, mid);
        String longestPalindrome2 = findLongestPalindromeByZhongxinTuozhan(s, mid - 1, mid);
        longestPalindrome = longestPalindrome1.length() > longestPalindrome2.length() ? longestPalindrome1 : longestPalindrome2;
        return longestPalindrome;
    }

    private String findLongestPalindromeByZhongxinTuozhan(String s, int left, int right) {
        String longestPalindrome = "";
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > longestPalindrome.length()) {
                    longestPalindrome = s.substring(left, right + 1);
                }
                left++;
                right--;
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
