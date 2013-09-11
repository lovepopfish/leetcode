public class Solution {
    public int atoi(String str) {
        str = str.trim();
        if (str.length()==0) return 0;
        int sign = 1;
        int i = 0;
        if (str.charAt(0)=='+'){
            i++;
        } else if (str.charAt(0)=='-') {
            i++;
            sign = -1;
        }
        long num = 0;
        while(i < str.length()){
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            }
            num = num * 10 + str.charAt(i)-'0';
            i++;
        }
        if (num*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)num*sign;
    }
}