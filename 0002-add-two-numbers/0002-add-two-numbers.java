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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null)
        return null;

        ListNode temp1 = l1.next;
        ListNode temp2 = l2.next;

        int s = l1.val+l2.val;
        
        
        ListNode head = new ListNode(s%10);
        ListNode temp3 = head;
        int carry = s/10;

        while(temp1 != null || temp2 != null){
            if(temp1 != null && temp2 != null){
                int sum = temp1.val+temp2.val+carry;
                carry = sum/10;
                temp3.next = new ListNode(sum%10);
                temp3 = temp3.next;
                temp1 = temp1.next;
                temp2 = temp2.next;               
            }
            else if(temp1 != null){
                int sum = temp1.val+carry;
                carry = sum/10;
                temp3.next = new ListNode(sum%10);
                temp3 = temp3.next;
                temp1 = temp1.next;
            }
            else{
                int sum = temp2.val+carry;
                carry = sum/10;
                temp3.next = new ListNode(sum%10);
                temp3 = temp3.next;
                temp2 = temp2.next;

            }
        }

        if(carry != 0){
            temp3.next = new ListNode(carry);
            return head;
        }
        return head;
        
    }
}