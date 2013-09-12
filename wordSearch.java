public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word==null ||word.length()==0) return true;
        int row = board.length;
        int col = board[0].length;
        char c = word.charAt(0);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j] = ' ';
                    if (dfs(board,word.substring(1),i,j)) {return true;}
                    board[i][j] = c;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int x, int y){
        if (word.length()==0) return true;
        int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        char c = word.charAt(0);
        for(int[] d:dir){
            int i = x + d[0];
            int j = y + d[1];
            if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]==c){
                board[i][j] = ' ';
                if (dfs(board,word.substring(1),i,j)) {return true;}
                board[i][j] = c;
            }
        }
        return false;
    }
}