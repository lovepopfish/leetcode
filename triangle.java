public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size()==0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if (j==0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        Arrays.sort(dp[n-1]);
        return dp[n-1][0];
    }
}