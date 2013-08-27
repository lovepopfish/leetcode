public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int sum = root.val;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l>0){
            sum += l;
        }
        if (r>0){
            sum += r;
        }
        max = Math.max(max,sum);
        return Math.max(l,r)>0? Math.max(l,r)+root.val:root.val;
    }
}