public class Solution {
    public String minWindow(String S, String T) {
        int[] needToFill = new int[256];
        int[] hasFound = new int[256];
        int count = 0;
        for(int i=0;i<T.length();i++){
            needToFill[T.charAt(i)]++;
        }
        int start = 0;
        String ret = "";
        for(int end = 0; end < S.length(); end++) {
            if (needToFill[S.charAt(end)]==0) continue;
            hasFound[S.charAt(end)]++;
            if (hasFound[S.charAt(end)] <= needToFill[S.charAt(end)]) {
                count++;
            }
            if (count==T.length()) {
                while (needToFill[S.charAt(start)]==0||hasFound[S.charAt(start)]>needToFill[S.charAt(start)]){
                    if (hasFound[S.charAt(start)] > needToFill[S.charAt(start)]) {
                        hasFound[S.charAt(start)]--;
                    }
                    start++;
                }
                if (ret=="" || end-start+1 < ret.length()) {
                    ret = S.substring(start,end+1);
                }
            }
        }
        return ret;
    }
}