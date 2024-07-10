package ch08;

public class Solution14 {

    public static void main(String[] args) {
        Solution14.ListNode list1 = new Solution14.ListNode(1, new Solution14.ListNode(2, new Solution14.ListNode(5, null)));
        Solution14.ListNode list2 = new Solution14.ListNode(1, new Solution14.ListNode(3, new Solution14.ListNode(4, null)));

        ListNode listNode = mergeTwoLists(list1, list2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
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

