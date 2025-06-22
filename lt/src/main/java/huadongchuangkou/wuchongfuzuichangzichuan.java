package huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

public class wuchongfuzuichangzichuan {
    // 最长无重复字符的子串
    public static int lengthOfLongestSubstring(String s) {
        // 1. 涉及到子串，考虑滑动窗口
        // 定义窗口
        // map存储窗口字符的情况，包括重复次数等！
        Map<Character, Integer> window = new HashMap<>();

        char[] strArr = s.toCharArray();
        // 固定模版
        // 2. 定义右指针 也是遍历指针 r<=strArr.length-1
        int right = 0;
        int left = 0;
        int max = 0;
        while (right <= strArr.length-1) {


            // 3. 字符加入窗口次数+1 注意这种写法 computeIfAbsent(arr[right],(k)->{
            // return 0;}) 也就是不存在返回0 存在count； 这种 computeIfAbsent 是计算 不是put值


            // 然后要将char的 count+1
            int count = window.computeIfAbsent(strArr[right], (k) -> {
                return 0;
            });
            window.put(strArr[right], ++count);
            // 4. 如果遇到了重复字符 缩减至无重复字符窗口。注意出现重复字符 不代表left第一个位置就是 重复字符。
            // 所以 要用while循环从left一点点缩小窗口，即 right的count不能大于1。
            // 缩小窗口是 left的 count-1，window.get(strArr[left]) - 1


            if (count > 1) {
                // 这里用while，比如 abcde c，第二个c出现需要将 a、b 都移出去！！
                while (checkRepeat(window, strArr[right])) {
                    // count-1 也就是移出窗口
                    window.put(strArr[left], window.get(strArr[left]) - 1);
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    private static boolean checkRepeat(Map<Character, Integer> window, char c) {
        return window.get(c) > 1;
    }



    public static int lengthOfLongestSubstring2(String s) {
        // 想到字串 首先考虑 滑动窗口。 left-right之间的字符串就是子串
        int left = 0;
        int right = 0;
        int maxLen = 0;
        // 使用 int[] 数组来存储子串 但是int[] 数组只适合 全小写英文字符的 这里使用 map 进行存储
        Map<Character, Integer> characterMap = new HashMap<>();
        while (right < s.length()) {
            // 将right加到窗口 增大窗口
            characterMap.put(s.charAt(right), characterMap.computeIfAbsent(s.charAt(right), (k) -> {return 0;}) + 1);
            // 出现重复
            // abcdb
            // 2. 缩小窗口也要用 while 因为可能不是只缩小一次！！
            while (characterMap.get(s.charAt(right))!=null &&  characterMap.get(s.charAt(right))>1) {
                // 重复边界 得到最长字串 同时 减少边界 缩小窗口
                // 缩小窗口和left++ 基本一定是同时发生的
                // 同时窗口减少
                // 1. 两者同时发生 且为了 将 left的重置掉，一定先缩小窗口再减小指针 left++ 放到后面
                // -1代表舍弃
                characterMap.put(s.charAt(left), characterMap.computeIfAbsent(s.charAt(left), (k) -> {return 0;}) - 1);
                left++;
            }
            // left-right 左闭右开是不重复子串
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
