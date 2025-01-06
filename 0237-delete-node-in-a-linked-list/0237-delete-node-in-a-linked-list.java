/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode prev = temp;

        while(temp != null){
            temp.val = temp.next.val;
            prev = temp;
            temp = temp.next;
            if(temp.next == null){
            prev.next = null;
            break;
            }
        }
    }
}