public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:prices){
            min = Math.min(min,i);
            max = Math.max(max,i-min);
        }
        return max;
    }
}