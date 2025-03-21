package hot100second.回溯法;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/21 13:42
 */
public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int rows=board.length,cols=board[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(board[i][j]==word.charAt(0)&&backtrack(0,i,j,board,word,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(int index,int row,int column,char[][] board,String word,boolean[][] visited){
        if(board[row][column]!=word.charAt(index)){
            return false;
        }else if(index==word.length()-1){
            return true;
        }
        boolean ans=false;
        visited[row][column]=true;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] direction:directions){
            int newRow=row+direction[0];
            int newCol=column+direction[1];
            if(isArea(board,newRow,newCol)&&!visited[newRow][newCol]){
                if(backtrack(index+1,newRow,newCol,board,word,visited)){
                    ans=true;
                    break;
                }
            }
        }
        visited[row][column]=false;
        return ans;

    }
    private boolean isArea(char[][] board,int row,int col){
        return row>=0&&row<board.length&&col>=0&&col<board[0].length;
    }
}
