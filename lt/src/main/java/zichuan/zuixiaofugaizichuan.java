package zichuan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class zuixiaofugaizichuan {
    class Solution {

        public String minWindow(String s, String t) {
            // 2. 因为全部是英文字母 可以用int[] 来定义窗口
            // 58 = 26+26+6 A为65  最后一个大写字母 90；与 a相差： 91-96 共 6个。 a为97 最后一个小写字母
            int[] swindow = new int[58];
            int right = 0;
            int left = 0;
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            int[] twindow = new int[58];
            String minStr = s + t;
            for (char tchar : tchars) {
                twindow[tchar - 'A']++;
            }

            while (right <= schars.length - 1) {
                boolean valid = true;
                // 加入窗口
                swindow[schars[right] - 'A']++;
                // 判断是否符合条件
                // 注意这里是包含 而不是全部相同。包含需要 count>
                for (int i = 0; i < twindow.length; i++) {
                    if (swindow[i] < twindow[i]) {
                        valid = false;
                    }
                }

                // 3. 每加入一个元素【字串变长】看看是否覆盖。 覆盖了 满满缩小窗口 找最小能覆盖的！！！

                while (valid) {
                    // 计算子串
                    String sonStr = s.substring(left, right + 1);
                    minStr = sonStr.length() < minStr.length() ? sonStr : minStr;
                    // left++ 窗口移动
                    swindow[schars[left] - 'A']--;
                    left++;
                    // 判断
                    for (int i = 0; i < twindow.length; i++) {
                        if (swindow[i] < twindow[i]) {
                            valid = false;
                        }
                    }
                }
                right++;
            }
            // 1. string比较 直接equals
            return minStr.equals(s + t) ? "" : minStr;
        }


        public String minWindow2(String s, String t) {
            // 子串是连续的 优先考虑滑动窗口 left-right的是子串
            // t子串， s原串
            // 子串问题考虑滑动窗口
            // 框架：增大窗口满足条件
            // 然后缩小窗口 直到不满足条件，继续增大窗口

            String minValidStr = s + "a";
            Map<Character, Integer> characterMap = new HashMap<>();
            Map<Character, Integer> subMap = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                subMap.put(t.charAt(i), subMap.computeIfAbsent(t.charAt(i), (k) -> {return 0;}) + 1);
            }

            // 基本框架
            int left = 0;
            int right = 0;
            while (right <= s.length() - 1) {
                // 将字符加入窗口 不停的增大窗口
                characterMap.put(s.charAt(right), characterMap.computeIfAbsent(s.charAt(right), (k) -> {return 0;}) + 1);
                right++; // 增大窗口 right++
                // 数据操作
                // 看看此时窗口是否完整包含 t
                // 遍历subMap 看看 对应的字符在characterMap是否完备
                AtomicReference<Boolean> valid = new AtomicReference<>(true);
                subMap.forEach((character, count) -> {
                    Integer characterCount = characterMap.get(character);
                    if (characterCount ==null || characterCount < count) {
                        valid.set(false);
                    }
                });
                // 当满足窗口条件 说明需要缩窗口 -> left++;
                while (valid.get()) {
                    characterMap.put(s.charAt(left), characterMap.computeIfAbsent(s.charAt(left), (k) -> {return 0;}) - 1);
                    // 判断是否还满足。
                    subMap.forEach((character, count) -> {
                        Integer characterCount = characterMap.get(character);
                        if (characterCount ==null || characterCount < count) {
                            valid.set(false);
                        }
                    });
                    // 不满足时记录
                    if (!valid.get()) {
                        String validStr = s.substring(left, right);
                        // 最小的
                        minValidStr = validStr.length() < minValidStr.length() ? validStr : minValidStr;
                    }
                    // 满足继续缩小窗口
                    left++;
                }
            }
            return minValidStr.length() > s.length() ? "" : minValidStr;
        }
    }
}
