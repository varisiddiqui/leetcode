/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        Stack<ListNode> sA = new Stack<>();
        Stack<ListNode> sB = new Stack<>();
        while(temp1 != null){
            sA.push(temp1);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            sB.push(temp2);
            temp2 = temp2.next;
        }

        if(sA.peek() != sB.peek())
        return null;
        ListNode intersect = null;
        while(sA.peek() == sB.peek()){
            sA.pop();
            intersect = sB.pop();
        }
        return intersect;
    }
}