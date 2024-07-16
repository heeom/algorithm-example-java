package algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueue {

    public static void main(String[] args) {
        createStack();
        queue();

        // Stack -> 모든 작업에 lock이 걸리는 Vector 자료형을 기반으로 하므로 사용 X -> Vector는 ArrayList로 개선되었다
        // Stack 대신 Deque사용
        // Thread safe 가 필요한 경우 -> LinkedBlockingDeque or ConcurrentLinkedDeque를 사용
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop: " + stack.pop());

    }



    /**
     * Queue
     *  구현체
     * - LinkedList
     * - ArrayDeque implements Deque
     */
    private static void queue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3); // 삽입
        queue.offer(4); // 추출
        System.out.println("poll : " + queue.poll());
    }

    private static void createStack() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (stack.last != null) {
            System.out.println("item : " + stack.pop());
        }
    }

    public static class Node {
        int item;
        Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static class Stack {
        Node last;

        public Stack() {
            this.last = null;
        }

        public void push(int item) {
            this.last = new Node(item, this.last);
        }

        public int pop() {
            int item = this.last.item;
            this.last = this.last.next;
            return item;
        }
    }

}
