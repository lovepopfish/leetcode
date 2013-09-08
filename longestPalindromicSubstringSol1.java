public class Solution {
    public String longestPalindrome(String s) {
        if (s.length()==0) return "";
        String longest = s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            String s1 = find(s,i,i);
            if (s1.length() > longest.length()){
                longest = s1;
            }
            String s2 = find(s,i,i+1);
            if (s2.length() > longest.length()){
                longest = s2;
            }
        }
        return longest;
    }
    public String find(String s, int i, int j){
        while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}