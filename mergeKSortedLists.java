public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size()==0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(ListNode n:lists){
            if (n!=null){
                minHeap.add(n);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode tmp = minHeap.poll();
            if (tmp.next!=null){
                minHeap.add(tmp.next);
            }
            cur.next = tmp;
            cur = cur.next;
        }
        return head.next;
    }
}