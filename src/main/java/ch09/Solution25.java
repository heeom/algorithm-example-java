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


}
