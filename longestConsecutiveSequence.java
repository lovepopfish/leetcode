apublic class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        int ret = 0;
        for(int i:num){
            set.add(i);
        }
        for(int i:num){
            if (set.contains(i)){
                ret = Math.max(ret,search(set,i,false) + search(set,i+1,true));
            }
        }
        return ret;
    }
    public int search(Set<Integer> set, int v, boolean isIncrease){
        int count = 0;
        while (set.contains(v)){
            count++;
            set.remove(v);
            if(isIncrease){
                v++;
            } else {
                v--;
            }
        }
        return count;
    }
}