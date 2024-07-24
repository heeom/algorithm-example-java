package ch10;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution28 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            double left = calcDistanceFromBase(a1[0], a1[1]);
            double right = calcDistanceFromBase(a2[0], a2[1]);
            if (left == right) {
                return 0;
            } else if (left > right) {
                return 1;
            }
            return -1;
        });

        pq.addAll(Arrays.asList(points));

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private static double calcDistanceFromBase(int x, int y) {
        return (double) Math.sqrt(x * x + y * y);
    }
}
