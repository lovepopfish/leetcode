public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] mark = new boolean[256];
        int i = 0;
        int len = 0;
        for(int j=0;j<s.length();j++){
            if (!mark[s.charAt(j)]){
                mark[s.charAt(j)] = true;
            } else {
                len = Math.max(len,j-i);
                while(s.charAt(i)!=s.charAt(j)){
                    mark[s.charAt(i)] = false;
                    i++;
                }
                i++;
            }
        }
        len = Math.max(len,s.length()-i);
        return len;
    }
}