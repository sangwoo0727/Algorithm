/**
 * Definition for singly-linked list
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2!= null){
            cur.next = l2;
        }
        return head.next;
    }
}
