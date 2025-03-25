package hot100second.回溯法;

import java.util.*;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/25 09:45
 */
public class N皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        int[] queens=new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> columns=new HashSet<>();
        Set<Integer> diags1=new HashSet<>();
        Set<Integer> diags2=new HashSet<>();
        backtrack(ans,queens,n,0,columns,diags1,diags2);
        return ans;
    }
    private void backtrack(List<List<String>> ans,int[] queens,int n,int row,Set<Integer> columns,Set<Integer> diags1,Set<Integer> diags2){
        if(row==n){
            List<String> board=generateBoard(queens,n);
            ans.add(board);
        }else {
            for(int i=0;i<n;i++){
                if(columns.contains(i)){
                    continue;
                }
                int diag1=row-i;
                int diag2=row+i;
                if(diags1.contains(diag1)||diags2.contains(diag2)){
                    continue;
                }
                queens[row]=i;
                columns.add(i);
                diags1.add(diag1);
                diags2.add(diag2);
                backtrack(ans,queens,n,row+1,columns,diags1,diags2);
                queens[row]=-1;
                columns.remove(i);
                diags1.remove(diag1);
                diags2.remove(diag2);
            }
        }
    }
    private List<String> generateBoard(int[] queens,int n){
        List<String> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] row=new char[n];
            Arrays.fill(row,'.');
            row[queens[i]]='Q';
            board.add(new String(row));
        }
        return board;
    }
}
