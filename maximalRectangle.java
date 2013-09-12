public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int area = 0;
        int[] dp = new int[col+1];
        for(int i = 0; i < row; i++){
            for(int j = 0;j < col; j++){
                if (matrix[i][j] == '0'){
                    dp[j] = 0;
                } else {
                    dp[j]++;
                }
            }
            area = Math.max(area,hist(dp));
        }
        return area;
    }
    
    public int hist(int[] h){
        int i = 0;
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i < h.length){
            if (stack.isEmpty() || h[stack.peek()]<=h[i]){
                stack.push(i++);
            } else {
                int tmp = stack.pop();
                if (stack.isEmpty()){
                    area = Math.max(area,h[tmp] * i);
                } else {
                    area = Math.max(area,h[tmp] * (i - stack.peek() - 1));
                }
            }
        }
        return area;
    }
}