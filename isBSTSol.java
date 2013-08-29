public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        return isValidBST(root,null,null);
    }
    private boolean isValidBST(TreeNode root, Integer min, Integer max){
        if (root==null) return true;
        if (min!=null){
            if (root.val<=min){
                return false;
            }
        }
        if (max!=null){
            if (root.val>=max){
                return false;
            }
        }
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}