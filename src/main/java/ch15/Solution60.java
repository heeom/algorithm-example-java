package ch15;

import java.util.*;

public class Solution60 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = findKthLargest(nums, 4);
        System.out.println(kthLargest);

        int kthLargestWithPq = findKthLargestWithPq(nums, 4);
        System.out.println(kthLargestWithPq);
    }

    public static int findKthLargest(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap();
        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i = 0; i < k-1; i++) {
            maxHeap.pop();
        }
        return maxHeap.pop();
    }

    public static class MaxHeap {
        List<Integer> elems;

        public MaxHeap() {
            this.elems = new ArrayList<>();
            this.elems.add(null);
        }

        public void add(int num) {
            elems.add(num);
            upHeap();
        }

        private void upHeap() {
            int last = elems.size() - 1;

            // 부모노드보다 크면 swap
            int parent = last / 2;
            while (parent > 0) {
                if (elems.get(parent) < elems.get(last)) {
                    swap(last, parent);
                }
                last = parent;
                parent = last / 2;
            }
        }

        public int pop() {
            int max = elems.get(1);
            // 맨 마지막 노드 root로 올림
            elems.set(1, elems.get(elems.size()-1));
            elems.remove(elems.size()-1);
            downHeap(1);
            return max;
        }

        private void downHeap(int idx) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int maximumIndex = idx;

            if (left < elems.size() && elems.get(maximumIndex) < elems.get(left)) {
                maximumIndex = left;
            }

            if (right < elems.size() && elems.get(maximumIndex) < elems.get(right)) {
                maximumIndex = right;
            }

            if (maximumIndex != idx) {
                swap(maximumIndex, idx);
                downHeap(maximumIndex);
            }
        }
        private void swap(int i, int j) {
            int value = elems.get(i);
            elems.set(i, elems.get(j));
            elems.set(j, value);
        }
    }

    public static int findKthLargestWithPq(int[] nums, int k) {
        //Comparator가 양수 반환시 swap
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); 도 가능 b > a 일때 스왑


        for (int num : nums) {
            pq.offer(num);
        }

        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}
