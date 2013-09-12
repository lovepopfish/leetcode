public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        if (s.length()<4||s.length()>12) return ret;
        dfs(ret,s,"",0);
        return ret;
    }
    
    public void dfs(ArrayList<String> ret, String s, String tmp,int part){
        if (part==3){
            if (isValid(s)){
                tmp += s;
                ret.add(tmp);
            }
            return;
        }
        for(int i=1;i<=3 && i<s.length();i++){
            String substr = s.substring(0,i);
            if (isValid(substr)){
                dfs(ret,s.substring(i),tmp+substr+".",part+1);
            }
        }
    }
    
    public boolean isValid(String s){
        if (s.charAt(0) == '0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num > 0 && num <= 255;
    }
}