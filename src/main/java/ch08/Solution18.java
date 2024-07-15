package ch08;

public class Solution18 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode listNode = oddEvenList(head);
    }
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddRoot = odd;
        ListNode evenRoot = even;
        int idx = 1;
        while (head != null) {
            ListNode next = head.next;
            if (idx % 2 == 0) {
                even.next = head;
                even.next.next = null;
                even = even.next;
            } else {
                odd.next = head;
                odd.next.next = null;
                odd = odd.next;
            }
            idx++;
            head = next;
        }

        // 홀수의 마지막 노드의 next에 짝수의 첫번째 노드 연결
        odd.next = evenRoot.next;

        return oddRoot.next;
    }
}
