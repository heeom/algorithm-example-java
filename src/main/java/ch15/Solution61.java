package ch15;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution61 {

    public static void main(String[] args) {
        int[] solution = solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        int[] solution2 = solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(solution);
        System.out.println(solution2);
    }

    static final String INSERT = "I";

    public static int[] solution(String[] operations) {
        Heap heap = new Heap();

        for (String operator : operations) {
            String[] s = operator.split(" ");

            String op = s[0];
            Integer num = Integer.valueOf(s[1]);

            if (INSERT.equals(op)) {
                heap.add(num);
            } else {
                heap.pop(num);
            }
        }
        return new int[] {heap.max(), heap.min()};
    }

    public static class Heap {

        Queue<Integer> maxHeap;
        Queue<Integer> minHeap;

        public Heap() {
            this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());;
            this.minHeap = new PriorityQueue<>();
        }

        public void add(int val) {
            maxHeap.add(val);
            minHeap.add(val);
        }
        public Integer pop(int operator) {
            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                return null;
            }

            if (operator > 0) {
                minHeap.remove(maxHeap.peek());
                return maxHeap.poll();
            } else {
                maxHeap.remove(minHeap.peek());
                return minHeap.poll();
            }
        }

        public int max() {
            if (maxHeap.isEmpty()) {
                return 0;
            }
            return maxHeap.peek();
        }

        public int min() {
            if (minHeap.isEmpty()) {
                return 0;
            }
            return minHeap.peek();
        }
    }
}
