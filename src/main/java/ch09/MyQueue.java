package ch09;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private final Deque<Integer> stack;
    private final Deque<Integer> temp;

    public MyQueue() {
        this.stack = new ArrayDeque<>();
        this.temp = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        peek();
        return temp.pop();
    }

    public int peek() {
        if (!temp.isEmpty()) {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
        }
        return this.temp.peek();
    }

    public boolean empty() {
        return this.stack.isEmpty() && this.temp.isEmpty();
    }
}
