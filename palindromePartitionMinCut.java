public class Solution {
    public int minCut(String s) {
        boolean[][] T = table(s);
        int len = s.length();
        int[] cut = new int[len+1];
        cut[len] = 0;
        for(int i=len-1;i>=0;i--){
            cut[i] = len - i;
            for (int j=i;j<len;j++){
                if(T[i][j]){
                    cut[i] = Math.min(cut[i],1+cut[j+1]);
                }
            }
        }
        return cut[0] - 1;
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
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                T[l--][r++] = true;
            }
            l = i - 1;
            r = i + 1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                T[l--][r++] = true;
            }
        }
        return T;
    }
}