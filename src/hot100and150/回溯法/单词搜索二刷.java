package hot100and150.回溯法;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/2/24 09:46
 */
public class 单词搜索二刷 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(0, i, j, board, word, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    //传入参数应该有：当前检查到word的位数，word字符串，矩阵board，访问数组visit
    public boolean backtrack(int index, int row, int column, char[][] board, String word, boolean[][] visit) {

        if (board[row][column] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        boolean ans = false;
        visit[row][column] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //该节点合法且未被访问过并选择该节点
        for (int[] dir : directions) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newColumn >= 0 && newRow < board.length && newColumn < board[0].length) {
                if (!visit[newRow][newColumn]) {
                    if (backtrack(index + 1, newRow, newColumn, board, word, visit)) {
                        ans = true;
                        break;
                    }
                }
            }

        }
        visit[row][column] = false;
        return ans;
    }
}
