public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int val = preorder[0];
        int i = 0;
        while(inorder[i]!=val){
            i++;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),
                              Arrays.copyOfRange(inorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),
                               Arrays.copyOfRange(inorder,i+1,inorder.length));
        return root;
    }
}