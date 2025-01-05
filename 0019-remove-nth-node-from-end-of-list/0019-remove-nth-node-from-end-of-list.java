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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode fast = head;
        int count = 0;
        while(fast!=null && fast.next!=null){
            count++;
            fast = fast.next.next;
        }
        int size = 0;
        if(fast == null){
            size = count*2;
        }
        else{
            size = count*2+1;
        }
        ListNode temp = head;
        int i=1;
         if(size-n+1 == 1){
                head = head.next;
                return head;
            }

        while(++i < (size-n+1)){
           
            temp = temp.next;
        }
        
        temp.next = temp.next.next;
        return head;
    }
}