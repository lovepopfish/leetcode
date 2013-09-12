public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        dfs(ret,tmp,n,k,1);
        return ret;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> tmp, int n, int k, int pos){
        if (k == 0){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=pos;i<=n;i++){
            tmp.add(i);
            dfs(ret,tmp,n,k-1,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}