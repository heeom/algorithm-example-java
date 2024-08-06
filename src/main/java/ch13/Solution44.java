package ch13;


import java.util.*;

public class Solution44 {
    public static void main(String[] args) {
        int i = networkDelayTime(new int[][]{new int[]{1,2,1}, new int[]{2,1,3}}, 2, 2);
        System.out.println(i);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int [] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[] {time[1], time[2]});
        }

        boolean [] visited = new boolean [n+1];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(k);
        visited[k] = true;
        int total = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (!graph.containsKey(current)) {
                continue;
            }

            int max = 0;
            for (int [] next : graph.get(current)) {
                if (!visited[next[0]]) {
                    max = Math.max(max, next[1]);
                    queue.offer(next[0]);
                }
                visited[current] = true;
            }
            total += max;
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return total;
    }
}
