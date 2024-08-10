package ch13;

import java.util.*;

public class Solution44 {

    public static void main(String[] args) {
        int cheapestPrice = findCheapestPrice(3, new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}}, 0, 2, 0);
        System.out.println(cheapestPrice);
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        // 노드, 해당 노드까지 걸리는 비용, 남은 경로 -> 노드까지의 비용을 기준으로 정렬
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pq.offer(List.of(src, 0, 0));

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            Integer dest = cur.get(0);
            Integer weight = cur.get(1);
            Integer degree = cur.get(2);
            if (dst == dest) {
                return weight;
            }
            visited.put(dest, degree);

            if (degree <= k) {
                degree += 1;
                if (graph.containsKey(dest)) {
                    for (Map.Entry<Integer, Integer> next : graph.get(dest).entrySet()) {
                        if (!visited.containsKey(next.getKey()) || degree < visited.get(next.getKey())) {
                            pq.add(List.of(next.getKey(), next.getValue() + weight, degree));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
