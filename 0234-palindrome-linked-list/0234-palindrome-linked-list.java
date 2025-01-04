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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        else if(head.next == null) return true;

        ListNode temp = head;
        ListNode curr = null;

        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                curr = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }

        ListNode next;
        ListNode prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode revHead = prev;
        while(head != null && revHead != null){
            if(head.val != revHead.val)
            return false;

            head = head.next;
            revHead = revHead.next;
        }
        
        if(head == null && revHead == null)
        return true;
        else
        return false;

        
    }
}