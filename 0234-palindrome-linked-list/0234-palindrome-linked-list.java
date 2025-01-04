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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
        arr.add(temp.val);
        temp = temp.next;
    }
    temp = head;
    
    for(int i=arr.size()-1; i>=0; i--){
        if(arr.get(i) != temp.val)
        return false;

        temp = temp.next;
    }
    return true;
    
    
    }
}