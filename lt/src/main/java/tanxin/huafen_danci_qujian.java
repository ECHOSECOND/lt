package tanxin;

import java.util.ArrayList;
import java.util.List;

public class huafen_danci_qujian {
    /**
     * 1. 划分区间 有点类似于回溯的思想 去寻找组合总个数， 嵌套的循环，循环从集合找元素
     * <p>
     * 但是 这次从集合找元素，是遍历字符串。需要找到最开始的字母和最远的字母位置，
     * <p>
     * 显然需要遍历一遍数组的。 回溯就不合适。
     * <p>
     * 2. 我们需要遍历一遍，将字母最远的位置记录下来。如果遍历到了最远位置就切割
     * <p>
     * 这样才能保证 字母不会出现在两段。
     * <p>
     * 注意我们需要取最远距离的字母，
     * <p>
     * 比如 ababcbacadefegdehijhklij
     * <p>
     * ababcb-> b遇到了最远位置，如果切割的话，a会散落在好几段
     * <p>
     * 所以需要遇到更远的 a 才进行切割。
     */
    public List<Integer> partitionLabels(String s) {
        int[] positions = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 记录字母位置，遍历，可能会记录到最远
            positions[s.charAt(i) - 'a'] = i;
        }

        // 用一个变量记录最远的位置
        int maxIdx = -1;
        int last=-1;

        for (int i = 0; i < s.length(); i++) {
            // 如果没有max 那么 只是 i=positions[s.charAt(i) - 'a']
            // 也就是字母遇到了最远的自己 ：
//                 * ababcb-> b遇到了最远位置的自己，如果切割的话，a会散落在好几段
//
//                 * 所以需要遇到更远的 a 才进行切割。
            maxIdx = Math.max(maxIdx, positions[s.charAt(i) - 'a']);
            // 从遍历以来 遇到了哪些字符，要找这个字符的最大距离。如果到了某个字母的最远距离
            if (maxIdx == i) {
                res.add(i-last);
                last = i;
            }
        }
        return res;
    }

}
