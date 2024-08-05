package ch12;

import java.util.*;

public class Solution43 {
    public static void main(String[] args) {
        boolean b = canFinish(2, new int[][]{new int[]{1, 2}});
        System.out.println(b);
        boolean result = canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}});
        System.out.println(result);
        boolean canFinish = canFinishFindLoop(2, new int[][]{new int[]{1, 0}, new int[]{1, 7}, new int[]{1, 5}, new int[]{2, 6}, new int[]{6, 4}, new int[]{7, 0}});
        System.out.println(canFinish);
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
}
