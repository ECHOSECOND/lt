package hash;

public class zimuyiweici {
    // 异位词分组
    // 异位词 是单词字母相同 顺序不一样的单词
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] strArr = str.toCharArray();
            // 对char数组排序
            Arrays.sort(strArr);
            // 排序后的字符串如果是 异位词 会相同 会成为相同的字符串
            List<String> list = map.computeIfAbsent(String.valueOf(strArr),(k)->{
                return new ArrayList<>();
            });
            list.add(str);
        }
        return new ArrayList(map.values());
    }
}
