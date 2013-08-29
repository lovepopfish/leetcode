public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num,0,num.length-1);
    }
    private TreeNode sortedArrayToBST(int[] num, int l, int r){
        if (l > r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode n = new TreeNode(num[mid]);
        n.left = sortedArrayToBST(num,l,mid-1);
        n.right = sortedArrayToBST(num,mid+1,r);
        return n;
    }
}