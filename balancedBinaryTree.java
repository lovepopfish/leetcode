public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int ret = checkHeight(root);
        if (ret==-1) return false;
        return true;
    }
    private int checkHeight(TreeNode root){
        if (root==null) return 0;
        int l = checkHeight(root.left);
        int r = checkHeight(root.right);
        if (l==-1) return -1;
        if (r==-1) return -1;
        if (Math.abs(l-r)>1) return -1;
        return Math.max(l,r)+1;
    }
}