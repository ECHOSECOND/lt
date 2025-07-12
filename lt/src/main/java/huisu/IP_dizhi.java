package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IP_dizhi {

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

        // 3. 当选了三个 最后一个不符合要求 直接返回。减少递归次数。
        if (path.size() == 3) {
            // 判断最后一个是否合法
            String last = s.substring(start);
            if (isValid(last)) {
                path.add(last);
                List<String> ips = path.stream().map(String::valueOf).collect(Collectors.toList());
                res.add(String.join(".", ips));
                path.remove(path.size() - 1);
            }
            return;
        }

        // 1. 从start开始尝试选取三个作为集合
        int len = 1;
        for (int i = start; i < start + 3; i++) {
            if (start + len <= s.length()) {
                String ele = s.substring(start, start + len);
                if (isValid(ele)) {
                    path.add(ele);
                    // 2. 嵌套的for循环去选
                    restoreIpAddresses(s, i + 1);
                    path.remove(path.size() - 1);
                }
            }
            len++;
        }

    }

    public boolean isValid(String ele) {
        if (ele == null || ele.isEmpty()) {
            return false;
        }
        if (ele.equals("0")) {
            return true;
        }
        if (ele.startsWith("0")) {
            return false;
        }
        // 字符串转数字
        char[] chars = ele.toCharArray();
        int num = 0;
        for (char c : chars) {
            num = num * 10 + c - '0';
            if (num > 255) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IP_dizhi d = new IP_dizhi();
        List<String> res = d.restoreIpAddresses("101023");
        System.out.println(Arrays.toString(res.toArray()));

//        System.out.println(Integer.parseInt("9245587303"));
    }

}
