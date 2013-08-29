public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        dfs(ret,tmp,root,sum);
        return ret;
    }
    private void dfs(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> tmp, TreeNode root, int sum){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null && root.val==sum){
            tmp.add(root.val);
            ret.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        }
        tmp.add(root.val);
        dfs(ret,tmp,root.left,sum-root.val);
        dfs(ret,tmp,root.right,sum-root.val);
        tmp.remove(tmp.size()-1);
    }
}