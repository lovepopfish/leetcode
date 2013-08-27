public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int n = prices.length;
        int min = prices[0];
        int max = prices[n-1];
        int ret = 0;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i=1;i<n;i++){
            min = Math.min(min,prices[i]);
            dp1[i] = Math.max(dp1[i-1],prices[i]-min);
        }
        for(int i=n-2;i>=0;i--){
            max = Math.max(max,prices[i]);
            dp2[i] = Math.max(dp2[i+1],max-prices[i]);
        }
        for(int i=0;i<n;i++){
            ret = Math.max(ret,dp1[i]+dp2[i]);
        }
        return ret;
    }
}