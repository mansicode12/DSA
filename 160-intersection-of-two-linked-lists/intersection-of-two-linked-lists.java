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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists
        while (a != b) {
            // When 'a' reaches end, start at headB
            a = (a == null) ? headB : a.next;
            // When 'b' reaches end, start at headA
            b = (b == null) ? headA : b.next;
        }

        return a; // Can be null if no intersection
    }
}
