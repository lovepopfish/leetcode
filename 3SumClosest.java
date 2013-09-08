public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int left = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<num.length-2;i++){
            if (i>0 && num[i]==num[i-1]){
                continue;
            }
            int j = i + 1;
            int k = num.length - 1;
            while (j < k){
                int tmp = num[i] + num[j] + num[k];
                if (tmp > target) {
                    if (tmp - target < left) {
                        left = tmp - target;
                        sum = tmp;
                    }
                    k--;
                } else if (tmp < target) {
                    if (target - tmp < left) {
                        left = target - tmp;
                        sum = tmp;
                    }
                    j++;
                } else {
                    return target;
                }
                
            }
        }
        return sum;
    }
}