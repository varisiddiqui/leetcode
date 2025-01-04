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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode temp = head;
        ListNode future = head.next;
        ListNode head2 = head.next;
        while(temp.next != null && future.next != null){
            temp.next = future.next;
            temp = temp.next;
            future.next = temp.next;
            future = future.next;
        }
        temp.next = head2;
        return head;
    }
}