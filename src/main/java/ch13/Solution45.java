package ch13;


import java.util.*;

public class Solution45 {
    public static void main(String[] args) {
        int i = networkDelayTime(new int[][]{new int[]{1,2,1}, new int[]{2,1,3}}, 2, 2);
        System.out.println(i);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int [] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        Map<Integer, Integer> distance = new HashMap<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> current = pq.poll();
            Integer u = current.getKey();
            Integer w = current.getValue();

            // u 노드까지 최단거리 계산
            if (!distance.containsKey(u)){
                distance.put(u, w);
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        // v.getKey() + w = u 노드까지 최단 거리 + u 노드에서 v 노드까지 거리
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), v.getValue() + w));
                    }
                }
            }
        }

        if (distance.size() == n) {
            return Collections.max(distance.values());
        }
        return -1;
    }
}
