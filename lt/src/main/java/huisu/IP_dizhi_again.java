package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IP_dizhi_again {

    private List<String> path = new ArrayList<String>();
    private List<String> res = new ArrayList<>();

    /**
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     */

    /**
     * 思路： 总体还是做选组合，最终返回组合总数；即回溯
     * <p>
     * 组合要从集合里面去选，集合需要我们自己创造（符合要求的）然后嵌套的继续从后面的集合去选
     */

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0);
        return res;
    }

    private void restoreIpAddresses(String s, int start) {

        // 1.我们是从集合里面去选， 我们写选取的逻辑 而不是简单的add(i)

        // 2. 回溯一定是path.add 和 remove 不要回溯里面写循环处理，前面我们写了选取逻辑，符合选取策略就add

        // 3. 跟回文一样，我们就遍历字符串 然后看区间是否符合预期 符合就选

        // 比较特殊 我们要遍历完整个字符串，需要在path=3的时候看最后一段是否符合预期

        if (start >= s.length()) {
            return;
        }

        // 因为需要是完整的字符串才行
        if (path.size() == 3) {
            if (isValid2(s,start,s.length()-1)){
                // 注意这里我们不往path加内容就不需要回溯！！
                String ip = String.join(".", path);
                ip+="."+s.substring(start);
                res.add(ip);
            }
        }

        // 注意遍历字符串
        for (int i = start; i < s.length(); i++) {
            // 看start-i 是否可选
            if (isValid2(s, start, i)) {
                path.add(s.substring(start, i + 1));
                restoreIpAddresses(s, i + 1);
                path.remove(path.size() - 1);
            }
        }


    }

    public boolean isValid2(String ele, int start, int end) {
        char[] chars = ele.toCharArray();
        // 一个字符
        if (start == end) {
            return true;
        }
        // 多个字符以0开始
        if (chars[start] == '0') {
            return false;
        }
        // 多个字符与255比较
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + chars[i] - '0';
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IP_dizhi_again d = new IP_dizhi_again();
        List<String> res = d.restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(res.toArray()));

//        System.out.println(Integer.parseInt("9245587303"));
    }

}
