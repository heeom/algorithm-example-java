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
            }
            for (int next : graph.get(n)) {
                stack.push(next);
            }
        }
        return visited;
    }
}
