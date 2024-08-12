package ch14;


import java.util.*;

public class Solution54 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int [] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                q.add(key);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                Integer neighbor = graph.get(leaf).get(0); // 리프노드이므로 이웃 노드는 항상 1개
                graph.get(neighbor).remove(leaf); // 이웃 노드에서 리프노드 제거
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
