package ch12;

import java.util.ArrayList;
import java.util.List;

public class Solution40 {

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 4});
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        // nCr, 0 <= r <= n 모두 구하기, 중복 허용하지 않음
        List<List<Integer>> result = new ArrayList<>();

        // r을 for문 돌릴 필요 없음 -> 어차피 모든 경로를 탐색할거니까
        dfs(nums, result, new ArrayList<>(), 0);

        return result;
    }

    public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> path, int idx) {
// 없어도 되는 조건 -> 모든 경로를 탐색하므로
//        if (path.size() == r) {
//            results.add(new ArrayList<>(path));
//            return;
//        }
        results.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, results, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
