/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return dfs(lists, 0, lists.length - 1);
    }

    public ListNode dfs(ListNode[] lists, int start, int end){
        if(start > end) return null;
        if(start == end) return lists[start];
        int midpoint = (start + end)/2;
        ListNode left = dfs(lists, start, midpoint);
        ListNode right = dfs(lists, midpoint + 1, end);
        return mergeLists(left, right);
    }

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                head = head.next;
                l2 = l2.next;
            }
        }

        while(l1 != null){
            head.next = new ListNode(l1.val);
            head = head.next;
            l1 = l1.next;
        }

        while(l2 != null){
            head.next = new ListNode(l2.val);
            head = head.next;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
