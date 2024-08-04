package ch12;

import java.util.*;

public class Solution43 {
    public static void main(String[] args) {
        boolean b = canFinish(2, new int[][]{new int[]{1, 2}});
        System.out.println(b);
        boolean result = canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}});
        System.out.println(result);
    }

    // TIMEOUT
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = getIntegerQueueMap(prerequisites);
        List<Integer> courses = new ArrayList<>();
        for (int key : map.keySet()) {
            map = getIntegerQueueMap(prerequisites);
            if (!dfs(map, key, courses)) {
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

    public static boolean dfs(Map<Integer, List<Integer>> preCourseMap, Integer current, List<Integer> courses) {
        // 순환구조이면 false
        if (courses.contains(current)) {
            return false;
        }

        if (preCourseMap.containsKey(current)) {
            courses.add(current);
            for (Integer next : preCourseMap.get(current)) {
                if (!dfs(preCourseMap, next, courses)) {
                    return false;
                }
                courses.remove(current);
            }
        }
        return true;
    }
}
