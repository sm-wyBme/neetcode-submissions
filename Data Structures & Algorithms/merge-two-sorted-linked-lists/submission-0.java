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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode headNode = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                headNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                headNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            headNode = headNode.next;
        } 

        while(list1 != null){
            headNode.next = new ListNode(list1.val);
            list1 = list1.next;
            headNode = headNode.next;
        }

        while(list2 != null){
            headNode.next = new ListNode(list2.val);
            list2 = list2.next;
            headNode = headNode.next;
        }
        return dummyNode.next;
    }
}