public class Solution {
    public void solve(char[][] board) {
        if (board==null ||board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        for(int j=0;j<col;j++){
            bfs(board,0,j);
            bfs(board,row-1,j);
        }
        for(int i=1;i<row-1;i++){
            bfs(board,i,0);
            bfs(board,i,col-1);
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
    public void bfs(char[][] board, int i, int j){
        Queue<Integer> queue = new LinkedList<Integer>();
        int row = board.length;
        int col = board[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        if (board[i][j]=='O') {
            queue.add(i*col+j);
        }
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            i = tmp/col;
            j = tmp%col;
            board[i][j] = 'D';
            for(int[] d:dir){
                int x = i + d[0];
                int y = j + d[1];
                if (x>=0 && x<row && y>=0 && y<col && board[x][y]=='O'){
                    queue.add(x*col+y);
                }
            }
        }
    }
}