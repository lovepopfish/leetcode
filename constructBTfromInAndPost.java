public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length==0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int val = postorder[postorder.length-1];
        int i = 0;
        while(inorder[i]!=val){
            i++;
        }
        root.left = buildTree(Arrays.copyOfRange(inorder,0,i),
                              Arrays.copyOfRange(postorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),
                               Arrays.copyOfRange(postorder,i,postorder.length-1));
        return root;
    }
}