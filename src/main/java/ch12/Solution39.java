package ch12;

import java.util.ArrayList;
import java.util.List;


public class Solution39 {

    public static void main(String[] args) {
        // 문제 잘읽기..
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // 숫자 조합 개수는 candidates.length보다 커도 됨
        dfs(candidates, target, results, new ArrayList<>(), 0);
        return results;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> results, List<Integer> path, int idx) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target-candidates[i], results, path, i); // 중복 가능하므로 i부터 탐색
            path.remove(path.size()-1);
        }
    }
}
