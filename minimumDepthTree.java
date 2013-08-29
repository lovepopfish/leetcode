public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l==0 && r==0) return 1;
        if (l==0 || r==0) return l==0?r+1:l+1;
        return Math.min(l,r)+1;
    }
}