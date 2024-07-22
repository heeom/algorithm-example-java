package ch09;

public class MyCircularDeque {

    private int currentLength;
    private final int size;
    private DoublyLinkedList head;
    private DoublyLinkedList tail;


    public MyCircularDeque(int k) {
        this.size = k;
        this.currentLength = 0;
        this.head = new DoublyLinkedList(0, null, null);
        this.tail = new DoublyLinkedList(0, null, null);
        this.head.setNext(tail);
        this.tail.setPrev(head);
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        DoublyLinkedList newHead = new DoublyLinkedList(value, null, null);
        newHead.setNext(this.head.getNext());
        newHead.setPrev(this.head);
        // head(0) 맨 앞에 둬야함
        this.head.getNext().setPrev(newHead);
        this.head.setNext(newHead);
        this.currentLength++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        DoublyLinkedList newTail = new DoublyLinkedList(value, null, null);
        newTail.setPrev(this.tail.getPrev());
        newTail.setNext(this.tail);
        this.tail.getPrev().setNext(newTail);
        this.tail.setPrev(newTail);
        this.currentLength++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.head.getNext().getNext().setPrev(this.head);
        this.head.setNext(this.head.getNext().getNext());
        this.currentLength--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        this.tail.getPrev().getPrev().setNext(this.tail);
        this.tail.setPrev(this.tail.getPrev().getPrev());
        this.currentLength--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.head.getNext().getVal();
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return this.tail.getPrev().getVal();
    }

    public boolean isEmpty() {
        return this.currentLength == 0;
    }

    public boolean isFull() {
        return this.size == this.currentLength;
    }
}
