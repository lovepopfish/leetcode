public class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l!=null) {
            root.right = l;
            root.left = null;
            TreeNode rMost = l;
            while (rMost.right!=null){
                rMost = rMost.right;
            }
            rMost.right = r;
        }
        flatten(root.right);
    }
}