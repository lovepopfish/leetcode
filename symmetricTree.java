public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode l, TreeNode r){
        if (l==null && r==null) return true;
        if (l==null || r==null) return false;
        if (l.val!=r.val) return false;
        return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
    }
}