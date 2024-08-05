package ch12;

import java.util.*;

public class Solution43 {
    public static void main(String[] args) {
//        boolean b = canFinish(2, new int[][]{new int[]{1, 2}});
//        System.out.println(b);
//        boolean result = canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}});
//        System.out.println(result);
//        boolean canFinish = canFinishFindLoop(2, new int[][]{new int[]{1, 0}, new int[]{1, 7}, new int[]{1, 5}, new int[]{2, 6}, new int[]{6, 4}, new int[]{7, 0}});
//        System.out.println(canFinish);
        canFinishBfs(2, new int[][]{new int [] {0,1}});
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = getIntegerQueueMap(prerequisites);
        List<Integer> courses = new ArrayList<>();
        List<Integer> finished = new ArrayList<>();
        for (Integer key : map.keySet()) {
            map = getIntegerQueueMap(prerequisites);
            if (!dfs(map, key, courses, finished)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, List<Integer>> getIntegerQueueMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int [] pre : prerequisites) {
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }
        return map;
    }

    public static boolean dfs(Map<Integer, List<Integer>> preCourseMap, Integer current, List<Integer> nextCourses, List<Integer> finishedCourses) {
        // 순환구조이면 false
        if (nextCourses.contains(current)) {
            return false;
        }

        if (finishedCourses.contains(current)) {
            return true;
        }

        if (preCourseMap.containsKey(current)) {
            nextCourses.add(current);
            for (Integer next : preCourseMap.get(current)) {
                if (!dfs(preCourseMap, next, nextCourses, finishedCourses)) {
                    return false;
                }
                nextCourses.remove(current);
                finishedCourses.add(current);
            }
        }
        return true;
    }


    // 시간 초과
    public static boolean canFinishFindLoop(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[0], new ArrayList<>());
            map.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean [] visited = new boolean[numCourses];
        for (Integer key : map.keySet()) {
            if (isLoop(map, visited, key)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 순환 구조인지 찾기
     * @param map key : 선행 수업, value : 선행 수업 다음 들어야하는 수업
     * @param visited 이미 수강한 수업
     * @param current 현재 수업
     * @return 현재 들어야하는 수업이 이미 수강한 수업 Set에 있다면 순환구조
     * ex) 1 -> 3, 3 -> 1 이면 current = 3 일때 visited.contains(3) = true 이므로 순환 구조
     *
     */
    public static boolean isLoop(Map<Integer, List<Integer>> map, boolean[] visited, Integer current) {
        if (visited[current]) {
            return true;
        }

        if (map.containsKey(current)) {
            visited[current] = true;
            for (Integer next : map.get(current)) {
                if (isLoop(map, visited, next)) {
                    return true;
                }
            }
        }
        visited[current] = false;
        return false;
    }

    /**
     * 위에 dfs 풀이 보다 훨씬 빠름
     * 예를 들면, 모든 차수가 > 0 인경우 탐색 안해도 됨
     * */
    public static boolean canFinishBfs(int numCourses, int[][] prerequisites) {
        // queue
        Queue<Integer> queue = new LinkedList<>();
        int [] degree = new int[numCourses];

        // graph 초기화
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            // 앞에 몇개의 노드가 있는지
            degree[prerequisites[i][1]]++;
        }

        int count = 0;
        // 차수가 0인 노드들(선행 수업이 없는 강의들 == 제일먼저 들어도 되는 강의들)
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int i = 0; i < graph.get(node).size(); i++) {
                Integer next = graph.get(node).get(i);
                degree[next]--;
                // 앞에 선행하는 노드가 없다면 탐색예정 큐에 삽입
                if (degree[next] == 0) {
                    queue.add(next);
                    count++; // 탐색한 노드 수
                }
            }
        }
        return count == numCourses;
    }
}
