package ch09;

public class DoublyLinkedList {
    private int val;
    private DoublyLinkedList prev;
    private DoublyLinkedList next;

    public DoublyLinkedList(int val, DoublyLinkedList prev, DoublyLinkedList next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public DoublyLinkedList getPrev() {
        return prev;
    }

    public DoublyLinkedList getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setPrev(DoublyLinkedList prev) {
        this.prev = prev;
    }

    public void setNext(DoublyLinkedList next) {
        this.next = next;
    }
}
