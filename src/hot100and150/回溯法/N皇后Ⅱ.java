package hot100and150.回溯法;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 12293
 * @description: n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * @date 2025/2/24 09:05
 */
public class N皇后Ⅱ {
    public int totalNQueens(int n) {

        Set<Integer> columns=new HashSet<>();
        Set<Integer> diagonals1=new HashSet<>();
        Set<Integer> diagonals2=new HashSet<>();
        return backtrack(n,0,columns,diagonals1,diagonals2);
    }
    public int backtrack(int n,int row,Set<Integer> columns,Set<Integer> diagonals1,Set<Integer> diagonals2){
        if(row==n){
            return 1;
        }else {
            int count=0;
            for (int i=0;i<n;i++){
                if(columns.contains(i)){
                    continue;
                }
                int diagonal1=row-i;
                if(diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2=row+i;
                if(diagonals2.contains(diagonal2)){
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count+=backtrack(n,row+1,columns,diagonals1,diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
    public int solve(int n,int row,int columns,int diagonals1,int diagonals2){
        if(row==n){
            return 1;
        }else {
            int count=0;
            int availablePositions=((1<<n)-1)&(~(columns|diagonals1|diagonals2));
            while (availablePositions!=0){
                int position=availablePositions&(-availablePositions);
                availablePositions=availablePositions&(availablePositions-1);
                count+=solve(n,row+1,columns|position,(diagonals1|position)<<1,(diagonals2|position)>>1);
            }
            return count;
        }
    }
}
