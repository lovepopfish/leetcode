public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        if (num.length < 4) {
            return ret;
        }
        for(int i=0;i<num.length-3;i++){
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            for(int j=i+1;j<num.length-2;j++){
                if (j > i+1 && num[j] == num[j-1]) {
                    continue;
                }
                int k = j+1;
                int h = num.length-1;
                while (k < h){
                    int sum = num[i] + num[j] + num[k] + num[h];
                    if (sum > target){
                        h--;
                    } else if (sum < target){
                        k++;
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        tmp.add(num[h]);
                        ret.add(tmp);
                        while(k < h && num[++k] == num[k-1]){}
                        while(k < h && num[--h] == num[h+1]){}
                    }
                }
            }
        }
        return ret;
    }
}