package tanxin;

import java.util.Arrays;

public class fenfa_binggan {

    public int findContentChildren(int[] g, int[] s) {
        /**
         * 1. 胃口和饼干尺寸都是升序的
         *
         * 2. 从后往前遍历。 遍历胃口，饼干满足就给，饼干指针跟着动 不然下一个胃口,饼干指针不动
         */
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int res = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            // 如果饼干满足
            if (index>=0 && s[index] >= g[i]) {
                index--;
                res++;
            }
        }
        return res;
    }
}
