public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        dfs(ret,tmp,s);
        return ret;
    }
    public void dfs(ArrayList<ArrayList<String>> ret, ArrayList<String> tmp, String s){
        if (s.length()==0){
            ret.add(new ArrayList<String>(tmp));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String substr = s.substring(0,i);
            if (isValid(substr)){
                tmp.add(substr);
                dfs(ret,tmp,s.substring(i));
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public boolean isValid(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if (s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}