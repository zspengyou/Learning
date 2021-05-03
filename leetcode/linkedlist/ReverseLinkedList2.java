package leetcode.linkedlist;

public class ReverseLinkedList2 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode runner = head;
            for (int i = 1; i < m; i++) {
                dummy = runner;
                runner = runner.next;
            }
            ListNode leftPre = dummy;
            ListNode left = runner;
            ListNode runnerN = runner.next;
            for (int i = m; i < n; i++) {
                ListNode runnerNN = runnerN == null ? null : runnerN.next;
                runnerN.next = runner;
                runner = runnerN;
                runnerN = runnerNN;
            }
            leftPre.next = runner;
            left.next = runnerN;
            if (m == 1) {
                return dummy.next;
            } else {
                return head;
            }
        }
    }


    class Solution2 {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) {
                return head;
            }
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode startPrevious = dummyHead;
            for (int i = 0; i < m - 1; i++) {
                startPrevious = startPrevious.next;
            }
            ListNode start = startPrevious.next;
            ListNode runner = start;
            ListNode runnerNext = runner.next;
            start.next = null;
            for (int i = m; i < n; i++) {
                ListNode runnerNextNext = runnerNext.next;
                runnerNext.next = runner;
                runner = runnerNext;
                runnerNext = runnerNextNext;
            }
            ListNode end = runner;
            ListNode endNext = runnerNext;
            start.next = endNext;
            startPrevious.next = end;
            return dummyHead.next;
        }
    }
}
