package ch08;

public class Solution17 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = swapPairsWithRecursion(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode root = node;
        node.next = head;

        while (node.next != null && node.next.next != null) {
            ListNode first = node.next;
            ListNode second = node.next.next;
            // a -> b -> c
            // a -> c  / node.next == a
            first.next = second.next;
            // node.next = b로 교체
            node.next = second;
            // b -> a -> c
            second.next = first;
            // node = c
            node = node.next.next;
        }
        return root.next;
    }


    public static ListNode swapPairsValue(ListNode head) {
        ListNode node = head;

        while (node != null && node.next != null) {
            if (node.val % 2 == 0) {
                continue;
            }
            int tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            node = node.next.next;
        }
        return head;
    }

    public static ListNode swapPairsWithRecursion(ListNode head) {
        if (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = swapPairsWithRecursion(head.next.next);
            next.next = head;
            return next;
        }
        return head;
    }
}
