package hot100.图论;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。


public class 岛屿数量 {
    public int numIslands(char[][] grid){
        int count=0;
        if(grid==null){
            return 0;
        }
        for(int x=0;x<grid.length;x++){
            for (int y=0;y<grid[0].length;y++){
                if(grid[x][y]=='1'){
                    count++;
                    dfs(grid,x,y);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int x,int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]!='1'){
            return;
        }
        grid[x][y]='2';
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
    }
}
