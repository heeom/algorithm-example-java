package algo;

import java.util.*;

public class Graph {
    private static HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        graph.put(1, Arrays.asList(2,3,4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6,7));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList(3));
        recursiveDfs(1, new ArrayList<>());
        iterativeDfs(1);
        Integer[] array = bfsWithQueue(1).toArray(new Integer[0]);
        System.out.println(array);
    }

    private static List<Integer> recursiveDfs(int n, List<Integer> visited) {
        visited.add(n);
        for (int next : graph.get(n)) {
            if (!visited.contains(next)) {
                visited = recursiveDfs(next, visited);
            }
        }
        return visited;
    }

    private static List<Integer> iterativeDfs(int n) {
        List<Integer> visited = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(n);

        while (!stack.isEmpty()) {
            n = stack.pop();
            if (!visited.contains(n)) {
                visited.add(n);
                for (int next : graph.get(n)) {
                    stack.push(next);
                }
            }
        }
        return visited;
    }

    private static List<Integer> bfsWithQueue(int n) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(n);
        queue.offer(n);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for (int next : graph.get(v)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return visited;
    }
}
