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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode  newHead = head.next;
        ListNode  current = head;
        ListNode prev = null; // rack last node
        while(current != null && current.next != null){
            // find put pairs for swapping
            ListNode first = current;
            ListNode  second = current.next;
            ListNode nextPair = second.next;
            second.next = first;
            first.next = nextPair;
            if(prev != null){
                prev.next = second;
            }
            prev = first;
            current = nextPair;
        }
    return newHead;
    }
}