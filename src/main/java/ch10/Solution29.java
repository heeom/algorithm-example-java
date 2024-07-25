package ch10;

import java.util.*;

public class Solution29 {

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        // 주어진 모든 스코빌이 K 보다 큰 경우
        if (pq.peek() >= K) {
            return answer;
        }

        while (pq.size() > 1) {
            answer++;
            pq.add(pq.poll() + pq.poll() * 2);
            if (pq.peek() >= K) {
                return answer;
            }
        }

        return -1;
    }
}
