public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        if (num.length<3) return ret;
        for(int i=0;i<num.length-2;i++){
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            int target = 0 - num[i];
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                if (num[j] + num[k] > target){
                    k--;
                } else if (num[j] + num[k] < target){
                    j++;
                } else {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[j]);
                    tmp.add(num[k]);
                    ret.add(tmp);
                    while(j<k && num[++j] == num[j-1]){}
                    while(j<k && num[--k] == num[k+1]){}
                }
            }
        }
        return ret;
    }
}