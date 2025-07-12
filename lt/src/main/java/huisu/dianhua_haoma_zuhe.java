package huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dianhua_haoma_zuhe {

    private StringBuilder sb = new StringBuilder();
    private List<String> res = new ArrayList<>();

    /**
     * 1. 还是从集合里面去做选择，只不过这个变化的集合，是通过 数字 -> 指向集合
     *
     * 2. 嵌套的for循环 去遍历集合选择。进入到下一层循环（递归）时，改变集合索引的index
     *
     * 也是只能选后面的 index+1 对应的集合。
     *
     * 3. 传入的字符串如 "23" 相当于对应 2的集合 + 3的集合 ， 递归时选择 index+1
     *
     * 这样自然集合范围也就隔离开了。
    *
    */
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        letterCombinations0(digits, 0, map);
        return res;
    }

    // 1. 传入的pos 相当于决定了 去选择哪个集合
    private void letterCombinations0(String digits, int pos, Map<Character, char[]> map) {
        if (pos >= digits.length()) {
            return;
        }
        // 选择了后
        // 遍历剩余选择列表。 剩余选择列表 也不存在重复的情况 所以 可将选择与撤销选择写在 for 循环内部
        char[] chars = digits.toCharArray();
        char c = chars[pos];
        char[] chooses = map.get(c);

        // 2. 嵌套的for循环，递归时 pos+1 进入另一个集合选择
        for (int i = 0; i < chooses.length; i++) {
            // 这种选择列表不再包含自己的 可以将 选择和撤销选择逻辑 写在 for循环内部。
            // 这种不重复的 需要pos++
            // 选择
            sb.append(chooses[i]);
            if (sb.length() == chars.length) {
                res.add(sb.toString());
            }
            // i同样会有多种选择
            letterCombinations0(digits, pos + 1, map);
            // 撤销
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
