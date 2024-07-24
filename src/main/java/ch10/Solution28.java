package ch10;

import java.util.Arrays;
import java.util.Comparator;
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



    public int[][] kClosestWithPoint(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));
        for (int [] point : points) {
            pq.add(new Point(calcDistance(point[0], point[1]), point));
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().point;
        }
        return result;
    }

    private static double calcDistance(int x, int y) {
        return (double) x * x + y * y;
    }

    public static class Point {
        double distance;
        int [] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }
}
