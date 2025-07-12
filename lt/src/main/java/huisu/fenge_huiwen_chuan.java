package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 还是求解组合问题，可以想到用回溯
 *
 * 2. 回溯从集合里去选。 集合选择逻辑 即回文判断逻辑
 *
 * 3. 嵌套的for循环，第一层选完了 传index+1到下一层
 */

public class fenge_huiwen_chuan {

    private List<List<String>> res = new ArrayList<List<String>>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        partition(s, 0);
        return res;
    }

    private void partition(String s, int start) {
        // 从start到end选择 找回文串

        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 自己去创造集合遍历选择
        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s, start,i)){
                path.add(s.substring(start, i+1));
                // 嵌套的去遍历集合
                partition(s, i+1);
                path.remove(path.size()-1);
            }
        }

    }

    private boolean isHuiWen(String s, int start, int end) {
        char[] chars = s.toCharArray();
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "a";
        fenge_huiwen_chuan f = new fenge_huiwen_chuan();
        List<List<String>> res = f.partition(str);
        System.out.println(Arrays.deepToString(res.toArray()));
        // 如果start=end，那么 substring将得到的""
        System.out.println(str.substring(0,0));
    }

}
