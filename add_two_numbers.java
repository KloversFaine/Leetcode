/*
Lacurs coding;
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode (-1);  // initial node 
        ListNode cur = result; // a pointer
        ListNode a = l1 , b = l2 ;
        int carry = 0;
        while(a != null || b != null)
        {
            int d1 = a == null ? 0 : a.val;
            int d2 = b == null ? 0 : b.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode (sum % 10);
            cur = cur.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry == 1) cur.next =new ListNode(1);   
        return result.next;
    }
}
