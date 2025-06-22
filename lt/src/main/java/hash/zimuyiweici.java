package hash;

import java.util.*;

public class zimuyiweici {
    // 异位词分组
    // 异位词 是单词字母相同 顺序不一样的单词
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // 1. 因为字符顺序问题导致的 字符数组/字符串不一样 就先进行排序 可以形成字符数组 也就是字符串。
        for(String str : strs){
            char[] strArr = str.toCharArray();// 2.tocharArray 变成字符数组后排序 这样顺序一致字符串就一样了。 可以直接用map承接
            // 对char数组排序
            Arrays.sort(strArr); // 3. arrays.sort进行排序，注意它会影响原 charArray 这样排序完直接用 原charArray
            // 排序后的字符串如果是 异位词 会相同 会成为相同的字符串
            List<String> list = map.computeIfAbsent(String.valueOf(strArr),(k)->{
                return new ArrayList<>();
            });
            list.add(str);
        }
        return new ArrayList(map.values());
    }
}
