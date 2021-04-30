package leetcode.linkedlist;

public class ReverseLinkedList2 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode runner = head;
            while (m - 1 > 0) {
                dummy = runner;
                runner = runner.next;
                m--;
                n--;
            }
            ListNode leftPre = dummy;
            ListNode left = runner;
            ListNode runnerN = runner.next;
            while (n - 1 > 0) {
                ListNode runnerNN = runnerN == null ? null : runnerN.next;
                runnerN.next = runner;
                runner = runnerN;
                runnerN = runnerNN;
                n--;
            }
            leftPre.next = runner;
            left.next = runnerN;
            return head;
        }
    }
}
