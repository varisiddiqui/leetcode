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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 1;
        if(head == null)
        return null;

        else{
            
            while(temp != null){
            
                temp = temp.next;
                size++;
            }
            size--;
            int mid = (size%2 == 0)? (size+2)/2 : (size+1)/2;
            temp = head;
            int count =1;
            while(temp != null){
                if(count == mid){
                    return temp;
                }
                count++;
                temp = temp.next;

            }
            return null;


        }
        
    }
}