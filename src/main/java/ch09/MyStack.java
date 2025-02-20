package ch09;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private final Queue<Integer> queue1;
//    private final Queue<Integer> queue2;
//    private int top;


    public MyStack() {
        this.queue1 = new LinkedList<>();
//        this.queue2 = new LinkedList<>();
//        this.top = -1;
    }

    public void push(int x) {
//        this.queue1.offer(x);
//        this.top = x;
        this.queue1.add(x);
        for (int i = 1; i < this.queue1.size(); i++) {
            queue1.add(this.queue1.poll()); // remove() 는 queue가 비었을 때 NoSuchElementException 예외를 던진다
        }
    }

    public int pop() {
//        while (this.queue1.size() > 1) {
//            Integer polled = this.queue1.poll();
//            this.queue2.offer(polled);
//            this.top = polled;
//        }
//        int end = this.queue1.poll();
//        while (!this.queue2.isEmpty()) {
//            this.queue1.offer(this.queue2.poll());
//        }
//        return end;
        return this.queue1.poll();
    }

    public int top() {
        return this.queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
