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
import java.util.*;
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);

        
        ListNode newhead = new ListNode(arr.get(0));
        ListNode dup = newhead;
        for(int i=1; i<arr.size(); i++){
            dup.next = new ListNode(arr.get(i));
            dup = dup.next;
        }
        return newhead;


    }
}