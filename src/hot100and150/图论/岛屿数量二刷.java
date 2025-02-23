package hot100and150.图论;

/**
 * @author hxg
 * @description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * @date 2025/2/23 10:53
 */
public class 岛屿数量二刷 {

    public int numIslands(char[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int r,int c){
        if(!inArea(grid,r,c)){
            return;
        }
        if(grid[r][c]!='1'){
            return;
        }
        grid[r][c]='2';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
    public boolean inArea(char[][] grid,int r,int c){
        return 0<=r&&r<grid.length&&0<=c&&c<grid[0].length;
    }
}
