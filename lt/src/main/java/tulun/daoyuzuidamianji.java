package tulun;

import java.util.Scanner;

/**
 * 找到有陆地的 重置计数器 开始计数
 *
 * 相当于遍历整个子树[多叉树，图遍历=树遍历]，遇到节点就 count++
 *
 * 相当于遇到了陆地 就开始遍历以该节点开始的 整个子树，子树节点数就是 岛屿面积
 *
 * 节点结束了 算最大面积
 */
public class daoyuzuidamianji {
    static final int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    static int result=0;
    static int count=0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=scanner.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]&&map[i][j]==1){
                    count=0;
                    dfs(map,visited,i,j);
                    result= Math.max(count, result);
                }
            }
        }
        System.out.println(result);
    }

    static void dfs(int[][] map,boolean[][] visited,int x,int y){
        count++;
        visited[x][y]=true;

        // 四个子节点
        for (int i = 0; i < 4; i++) {
            int nextX=x+dir[i][0];
            int nextY=y+dir[i][1];
            //水或者已经访问过的跳过
            if(nextX<0||nextY<0
                    ||nextX>=map.length||nextY>=map[0].length
                    ||visited[nextX][nextY]||map[nextX][nextY]==0)continue;

            dfs(map,visited,nextX,nextY);
        }
    }
}
