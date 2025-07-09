package tulun.leetcode;

import java.util.LinkedList;
import java.util.List;

public class fulan_de_juzi {
    public int orangesRotting(int[][] grid) {
        LinkedList<Element> queue = new LinkedList<>();

        // 2. 这一步很关键 相当于找到图遍历的起始点，是可能会有多个的！！！
        initQueue(grid, queue);
        int rows = grid.length;
        int columns = grid[0].length;
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Element element = queue.poll();
                // 上下左右判断新鲜橘子的加进来并且污染
                // 左
                if (element.indexJ - 1 >= 0 && grid[element.indexI][element.indexJ - 1] == 1) {

                    // 1. 注意我们 这里已经修改了 元素值为2，下次就不再符合条件了所以 其实已经起到了visted的作用
                    // 而且我们只会加 == 1的 元素
                    // 所以这里的图遍历没有 使用 visted
                    // 像岛屿问题 也是类似的，如果我们已经改了 元素本身的值，就不需要visited了！！

                    grid[element.indexI][element.indexJ - 1] = 2;
                    queue.add(new Element(element.indexI, element.indexJ - 1));
                }
                // 右
                if (element.indexJ + 1 <= columns - 1 && grid[element.indexI][element.indexJ + 1] == 1) {
                    grid[element.indexI][element.indexJ + 1] = 2;
                    queue.add(new Element(element.indexI, element.indexJ + 1));
                }
                // 上
                if (element.indexI - 1 >= 0 && grid[element.indexI - 1][element.indexJ] == 1) {
                    grid[element.indexI - 1][element.indexJ] = 2;
                    queue.add(new Element(element.indexI - 1, element.indexJ));
                }
                // 下
                if (element.indexI + 1 <= rows - 1 && grid[element.indexI + 1][element.indexJ] == 1) {
                    grid[element.indexI + 1][element.indexJ] = 2;
                    queue.add(new Element(element.indexI + 1, element.indexJ));
                }
            }
            count++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        // 3. count=-1表明没有坏掉的橘子 全是空格子和1 说明0分钟就可以 实现全部腐烂的效果。这是边界情况！！！
        if(count==-1){
            return 0;
        }
        return count;
    }

    private void initQueue(int[][] grid, List<Element> queue) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Element(i, j));
                }
            }
        }
    }
        class Element {
            int indexI;
            int indexJ;

            public Element(int indexI, int indexJ) {
                this.indexI = indexI;
                this.indexJ = indexJ;
            }
        }
}
