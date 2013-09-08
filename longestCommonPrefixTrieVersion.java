public class Solution {
    private TrieNode root;
    private class TrieNode{
        LinkedList<TrieNode> list;
        char c;
        boolean terminate = false;
        public TrieNode(){
            list = new LinkedList<TrieNode>();
        }
        
        public TrieNode(char c){
            this();
            this.c = c;
        }
        
        public TrieNode getNode(char c){
            for(TrieNode node:list){
                if (node.c == c){
                    return node;
                }
            }
            return null;
        }
        
        public LinkedList<TrieNode> getList(){
            return list;
        }
        
        public void addWord(String word){
            if (word.length()==0) return;
            TrieNode cur = getNode(word.charAt(0));
            if (cur==null){
                cur = new TrieNode(word.charAt(0));
                list.add(cur);
            }
            if (word.length()>1){
                cur.addWord(word.substring(1));
            } else {
                cur.terminate = true;
            }
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        root = new TrieNode();
        for(String s:strs){
            if (s.length()==0) return "";
            root.addWord(s);
        }
        TrieNode cur = root;
        while (cur.getList().size()==1){
            cur = cur.getList().get(0);
            sb.append(cur.c);
            if (cur.terminate==true) break;
        }
        return sb.toString();
    }
}