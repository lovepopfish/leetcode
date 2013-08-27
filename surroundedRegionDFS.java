public class Solution {
    public void solve(char[][] board) {
        if (board==null ||board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        for(int j=0;j<col;j++){
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        for(int i=1;i<row-1;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (board[i][j]=='D') {
                    board[i][j] = 'O';
                } else if (board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        if (i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='O'){
            board[i][j] = 'D';
            dfs(board,i+1,j);
            dfs(board,i-1,j);
            dfs(board,i,j+1);
            dfs(board,i,j-1);
        }
    }
}