public class Solution {
    public int trap(int[] A) {
        int mid = 0;
        for(int i=0;i<A.length;i++){
            if (A[i] > A[mid]){
                mid = i;
            }
        }
        int curMax = 0;
        int ret = 0;
        for(int i=0;i<mid;i++){
            curMax = Math.max(curMax,A[i]);
            if (A[i] < curMax){
                ret += curMax - A[i];
            }
        }
        curMax = 0;
        for(int i=A.length-1;i>mid;i--){
            curMax = Math.max(curMax,A[i]);
            if (A[i] < curMax){
                ret += curMax - A[i];
            }
        }
        return ret;
    }
}