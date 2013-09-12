public class Solution {
    public int largestRectangleArea(int[] height) {
        int[] h = Arrays.copyOf(height,height.length+1);
        int i = 0;
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int tmp = stack.pop();
                if (stack.isEmpty()){
                    area = Math.max(area, h[tmp] * i);
                } else {
                    area = Math.max(area, h[tmp] * (i - stack.peek() - 1));
                }
            }
        }
        return area;
    }
}