public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        dfs(ret,tmp,table(s),s,0);
        return ret;
    }
    public boolean[][] table(String s){
        int n = s.length();
        boolean[][] T = new boolean[n][n];
        for(int i=0;i<n;i++){
            T[i][i] = true;
        }
        for(int i=0;i<n;i++){
            int l = i - 1;
            int r = i;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                T[l--][r++] = true;
            }
            l = i - 1;
            r = i + 1;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                T[l--][r++] = true;
            }
        }
        return T;
    }
    public void dfs(ArrayList<ArrayList<String>> ret, ArrayList<String> tmp, boolean[][] T, String s, int pos){
        if (pos==s.length()){
            ret.add(new ArrayList<String>(tmp));
            return;
        }
        for(int i=pos; i<s.length(); i++){
            if (T[pos][i]){
                tmp.add(s.substring(pos,i+1));
                dfs(ret,tmp,T,s,i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}