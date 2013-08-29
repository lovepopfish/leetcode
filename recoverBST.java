public class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;
        dfs(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void dfs(TreeNode root){
        if (root==null) return;
        dfs(root.left);
        if (prev==null){
            prev = root;
        }
        if (prev.val > root.val){
            if (first==null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        dfs(root.right);
    }
}