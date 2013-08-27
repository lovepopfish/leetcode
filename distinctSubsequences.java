public class Solution {
    public int numDistinct(String S, String T) {
        if (T.length()==0) return 1;
        if (S.length()<T.length()) return 0;
        if (S.charAt(0)==T.charAt(0)) {
            return numDistinct(S.substring(1),T.substring(1)) +
            numDistinct(S.substring(1),T);
        } else {
            return numDistinct(S.substring(1),T);
        }
    }
}