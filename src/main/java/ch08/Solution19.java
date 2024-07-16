package ch08;

public class Solution19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = reverseBetween(head, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode start = root;

        for (int i = 0; i < left -1; i++) {
            start = start.next;
        }
        ListNode end = start.next;
        for (int i = left-1; i < right; i++) {
            ListNode next = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = next;
        }
        return root.next;
    }
}
