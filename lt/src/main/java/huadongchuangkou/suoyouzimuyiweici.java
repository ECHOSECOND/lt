package huadongchuangkou;

import java.util.*;

public class suoyouzimuyiweici {
    // 1. list转数组
    // window.toArray(new Character[window.size()]);
    // 2. 数组转list
    // Arrays.asList
    // 3. 字符数组判断是否相等 是可以用 Arrays.eqals 判断的！！！
    // 我们数组的存储为 各个字符的次数
    // 如果 数组存储个数都相同 说明 两个char[] 相同！！！ 就是用字符个数相同判断字符串相同！！

    // 子串 定义窗口
    public List<Integer> findAnagrams(String s, String p) {
        // 定义窗口int[]

        // 1. 字符串窗口用 int[] 来定义窗口 char-'a' 本身就是一个数字 一共26个从0到25.

        // 只有字符串可以的 用int[] 来存储窗口
        int[] swindow = new int[26];
        int[] pwindow = new int[26];
        char[] chars = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        int right = 0;
        int left = 0;
        int m = p.length();
        char[] charp = p.toCharArray();
        for (char c : charp) {
            pwindow[c - 'a']++;
        }
        while (right < chars.length) {
            swindow[chars[right] - 'a']++;

            // 2. 字符串用 int[] 定义窗口后，可以 Arrays.stream(swindow).sum() 来计算窗口总和

            if (Arrays.stream(swindow).sum() == m) {

                // 3. int[] 可以用 arrays.equals 来判断 两个字符串是不是相同。
                if (Arrays.equals(swindow, pwindow)) {
                    result.add(left);
                }
                // 这俩一定是同时出现的！！！！ 缩小窗口！！！
                swindow[chars[left] - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }


    // 使用map来定义窗口。 注意处理 map窗口元素是否相同 要元素count相同且不为0
    // 缩减窗口 都是 count-1的方式 不要删除元素！除非 count=0了！
    public List<Integer> findAnagrams2(String s, String p) {

        int left = 0;
        int right = 0;
        Map<Character, Integer> swindow = new HashMap<>();
        Map<Character, Integer> pwindow = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int pointer = 0;
        // p窗口
        while (pointer < p.length()) {
            pwindow.put(p.charAt(pointer), pwindow.getOrDefault(p.charAt(pointer), 0) + 1);
            pointer++;
        }
        while (right < s.length()) {
            // 判断窗口的元素=p的长度了。

            // swindow.getOrDefault(s.charAt(right), 0) + 1 等同于：
            //
            // int count = window.computeIfAbsent(strArr[right], (k) -> {
            //                return 0;
            //            });
            // count++

            swindow.put(s.charAt(right), swindow.getOrDefault(s.charAt(right), 0) + 1);
            if (right - left == p.length() - 1) { // 注意是 right-left=p.length()-1
                // 判断s和p window是否相同 是计算 窗口的和
                if (computeWindow(swindow, pwindow)) {
                    result.add(left);
                }
                // 缩小窗口 不需要循环去缩小，因为窗口大小就是 p.length
                // 窗口缩小不能去删 因为又可能重复 a有两个，删除一个a a变成了一个，而不要remove掉
                swindow.put(s.charAt(left), swindow.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            right++;
        }
        return result;
    }


    // 判断相等关系确实要遍历大的map，包含关系是遍历小的
    // 需要每个字符的count相同 认为 窗口的字符串相同。
    private boolean computeWindow(Map<Character, Integer> swindow, Map<Character, Integer> pwindow) {
        for (Map.Entry<Character, Integer> entry : swindow.entrySet()) {
            // 注意swindow 可能超过3个 排除掉为0的情况！！
            if (swindow.get(entry.getKey()) == 0) {
                continue;
            }
            if (!entry.getValue() .equals(pwindow.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        suoyouzimuyiweici suoyouzimuyiweici = new suoyouzimuyiweici();

        List<Integer> res = suoyouzimuyiweici.findAnagrams2(s, p);

        // list转数组
        System.out.println(Arrays.toString(res.toArray()));
    }

}
