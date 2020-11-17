/**
 * Definition for singly-linked list.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode_23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) return null;
        for(int dist = 1; dist < size; dist *= 2){
            for (int i = 0; i < size - dist; i += (dist *= 2)) {
                lists[i] = merge(lists[i], lists[i + 1]);
            }
        }
        return lists[0];
    }
    static ListNode merge(ListNode l1 , ListNode l2){
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = l1 != null? l1: l2;
        return head.next;
    }
}
