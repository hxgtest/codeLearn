package hot100second.图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/19 09:26
 */
public class 腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int count=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==1){
                    count++;
                }else if(grid[r][c]==2){
                    queue.add(new int[]{r,c});
                }
            }
        }
        int round=0;
        while (count>0&&!queue.isEmpty()){
            round++;
            int len =queue.size();
            for(int i = 0; i< len; i++){
                int[] orange=queue.poll();
                int r=orange[0],c=orange[1];
                if(r-1>=0&&grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    count--;
                    queue.add(new int[]{r-1,c});
                }
                if(c-1>=0&&grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    count--;
                    queue.add(new int[]{r,c-1});
                }
                if(r+1<m&&grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    count--;
                    queue.add(new int[]{r+1,c});
                }
                if(c+1<n&&grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    count--;
                    queue.add(new int[]{r,c+1});
                }

            }
        }
        if(count>0){
            return -1;
        }else {
            return round;
        }
    }
}
