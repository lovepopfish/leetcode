public class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()||stack.pop()!=map.get(s.charAt(i))){
                return false;
            }
        }
        return stack.isEmpty();
    }
}