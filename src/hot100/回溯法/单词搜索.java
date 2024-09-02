package hot100.回溯法;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
public class 单词搜索 {
    public boolean exist(char[][] board,String word){
        int rows=board.length,columns=board[0].length;
        boolean[][] visits=new boolean[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                boolean flag=backtrack(board,word,visits,i,j,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,String word,boolean[][] visits,int row,int column,int i){
        if(board[row][column]!=word.charAt(i)){
            return false;
        }else if(i==word.length()-1){
            return true;
        }
        visits[row][column]=true;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        boolean result=false;
        for(int[] dir:directions){
            int newRow=row+dir[0],newColumn=column+dir[1];
            if(newRow>=0&&newRow<board[0].length&&newColumn>=0&&newColumn< board[0].length){
                if(!visits[newRow][newColumn]){

                    boolean flag=backtrack(board,word,visits,newRow,newColumn,i+1);
                    if(flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        visits[row][column]=false;
        return result;
    }
}
