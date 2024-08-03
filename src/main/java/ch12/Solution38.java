package ch12;

import java.util.ArrayList;
import java.util.List;

public class Solution38 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), n, k, 1);
        return results;
    }

    public static void dfs(List<List<Integer>> results, List<Integer> path, int n, int k, int now) {
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = now; i <= n; i++) {
            path.add(i);
            dfs(results, path, n, k, i+1);
            // LinkedList.removeList();로 사용해도 됨
            path.remove(path.size()-1);
        }
    }
}
