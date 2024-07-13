package ch08;

public class Solution15 {

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> null
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result = reverseList(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        return recursiveCall(head, null);
    }

    public static ListNode recursiveCall(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }
        // null -> 1 -> 2
        // next = node.next
        // node.next = node.prev
        ListNode next = node.next;
        node.next = prev;
        // prev = node, node = next
        return recursiveCall(next, node);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
