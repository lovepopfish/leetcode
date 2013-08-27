public class Solution {
    public int numDistinct(String S, String T) {
        int row = S.length();
        int col = T.length();
        int[][] dp = new int[row+1][col+1];
        for(int i=0;i<row+1;i++){
            dp[i][0] = 1;
        }
        for(int j=1;j<col+1;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                if (S.charAt(i-1)==T.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[row][col];
    }
}