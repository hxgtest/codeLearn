package hot100.图论;
//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
//
//值 0 代表空单元格；
//值 1 代表新鲜橘子；
//值 2 代表腐烂的橘子。
//每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
//返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1
public class 腐烂的橘子 {
    public int orangesRotting(int[][] grid){
        int time=0,numNew=0;
        for(int x=0;x<grid.length;x++){
            for(int y=0;y<grid[0].length;y++){
                if(grid[x][y]==1){
                    numNew++;
                }
            }
        }
        while(numNew>0){
            int rec=numNew;
            for(int x=0;x<grid.length;x++){
                for(int y=0;y<grid[0].length;y++){
                    if(grid[x][y]==2){
                        numNew-=rott(grid,x,y);
                    }
                }
            }
            if(numNew==rec){
                return -1;
            }
            for(int x=0;x<grid.length;x++){
                for(int y=0;y<grid[0].length;y++){
                    if(grid[x][y]==3){
                        grid[x][y]=2;
                    }
                }
            }
            time++;
        }


        return time;
    }
    private int rott(int[][] grid,int x,int y){
        int num=0;
        if(x>0&&grid[x-1][y]==1){
            grid[x-1][y]=3;
            num++;
        }
        if(y>0&&grid[x][y-1]==1){
            grid[x][y-1]=3;
            num++;
        }
        if((x<grid.length-1)&&grid[x+1][y]==1){
            grid[x+1][y]=3;
            num++;
        }
        if((y<grid[0].length-1)&&grid[x][y+1]==1){
            grid[x][y+1]=3;
            num++;
        }
        return num;
    }
}
