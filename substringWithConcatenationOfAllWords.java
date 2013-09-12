public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (L.length==0) return ret;
        int count = L.length;
        int len = L[0].length();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String l : L){
            if (map.containsKey(l)){
                map.put(l,map.get(l)+1);
            } else {
                map.put(l,1);
            }
        }
        for(int i=0;i<=S.length()-count*len;i++){
            int pos = i;
            Map<String,Integer> tmp = new HashMap<String,Integer>(map);
            while(true){
                String substr = S.substring(pos,pos+len);
                if (!tmp.containsKey(substr)){
                    break;
                } else {
                    if (tmp.get(substr)==1){
                        tmp.remove(substr);
                    } else {
                        tmp.put(substr,tmp.get(substr)-1);
                    }
                }
                if (tmp.isEmpty()){
                    ret.add(i);
                    break;
                }
                pos += len;
            }
        }
        return ret;
    }
}