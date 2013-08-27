public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode cur = root.next;
        TreeLinkNode p = null;
        while(cur!=null){
            if(cur.left!=null){
                p = cur.left;
                break;
            }
            if(cur.right!=null){
                p = cur.right;
                break;
            }
            cur = cur.next;
        }
        if (root.right!=null) {
            root.right.next = p;
        }
        if (root.left!=null) {
            root.left.next = root.right==null?p:root.right;
        }
        connect(root.right);
        connect(root.left);
    }
}