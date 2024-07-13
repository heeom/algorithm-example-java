package ch08;

public class Solution16 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode root = node;
        int upper = 0;
        int sum = 0;
        while (l1 != null || l2 != null || upper != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            upper = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            sum = upper;
        }
        return root.next;
    }

    public ListNode addTwoListNode(ListNode l1, ListNode l2, int upper) {
        if (l1.next == null && l2 == null) {
            return l1;
        }

        int first = l1.val;
        int second = l2 == null ? 0 : l2.val;
        int sum = first + second + upper;
        l1.val = sum % 10;
        upper = sum / 10;

        if (l1.next == null && l2.next != null) {
            l1.next = l2.next;
            l2.next = null;
        }

        if (upper > 0 && l1.next == null) {
            l1.next = new ListNode(upper, null);
        }

        return addTwoNumbers(l1.next, l2 == null ? null : l2.next);
    }
}
