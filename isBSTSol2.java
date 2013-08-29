public class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        prev = null;
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if (root!=null) {
            if (!inorder(root.left)){
                return false;
            }
            if (prev!=null && prev.val >= root.val){
                return false;
            }
            prev = root;
            return inorder(root.right);
        }
        return true;
    }
}