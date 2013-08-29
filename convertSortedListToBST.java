public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        return sortedListToBST(list,0,list.size()-1);
    }
    private TreeNode sortedListToBST(ArrayList<Integer> list, int l, int r){
        if (l > r) return null;
        int mid = (l+r)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = sortedListToBST(list,l,mid-1);
        node.right = sortedListToBST(list,mid+1,r);
        return node;
    }
}