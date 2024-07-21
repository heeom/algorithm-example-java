package ch09;

import java.util.LinkedList;
import java.util.Queue;

public class Solution25 {

    public static class MyCircularQueue {

        private Queue<Integer> queue;
        private final int size;
        private int last;


        public MyCircularQueue(int k) {
            this.queue = new LinkedList<>();
            this.size = k;
            this.last = -1;
        }

        public boolean enQueue(int value) {
            if (this.queue.size() < this.size) {
                this.queue.add(value);
                this.last = value;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (this.queue.isEmpty()) {
                return false;
            }
            this.queue.remove();
            return true;
        }

        public int Front() {
            return this.queue.peek() == null ? -1 : this.queue.peek();
        }

        public int Rear() {
            return this.queue.isEmpty() ? -1 : this.last;
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public boolean isFull() {
            return this.queue.size() == this.size;
        }

    }

    public static class MyCircularQueueWithArray {

        private final int[] queue;
        private int front = 0;
        private int rear = -1;
        private int len = 0;


        public MyCircularQueueWithArray(int k) {
            this.queue = new int[k];
        }

        public boolean enQueue(int value) {
            if (!this.isFull()) {
                this.rear = ++this.rear % this.queue.length; // 한바퀴 돌았으면 나머지 위치로
                queue[this.rear] = value;
                this.len++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (!this.isEmpty()) {
                this.front = ++this.front % this.queue.length;
                this.len--;
                return true;
            }
            return false;
        }

        public int Front() {
            return this.isEmpty() ? -1 : this.queue[this.front];
        }

        public int Rear() {
            return this.isEmpty() ? -1 : this.queue[this.rear];
        }

        public boolean isEmpty() {
            return this.len == 0;
        }

        public boolean isFull() {
            return this.len == this.queue.length;
        }
    }
}
