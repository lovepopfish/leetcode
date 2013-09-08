public class Solution {
    public String longestPalindrome(String s) {
        if (s.length()==0) return "";
        int n = s.length();
        int index = 0;
        int longestLen = 1;
        boolean[][] T = new boolean[n][n];
        for(int i=0;i<n;i++){
            T[i][i] = true;
        }
        for(int i=0;i<n-1;i++){
            if (s.charAt(i) == s.charAt(i+1)){
                T[i][i+1] = true;
                index = i;
                longestLen = 2;
            }
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j = i + len - 1;
                if (T[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    T[i][j] = true;
                    index = i;
                    longestLen = len;
                }
            }
        }
        return s.substring(index,index+longestLen);
    }
}