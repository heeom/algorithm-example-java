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
        for (int r = 0; r <= nums.length; r++) {
            dfs(nums, result, new ArrayList<>(), r, 0);
        }
        return result;
    }

    public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> path, int r, int idx) {
        if (path.size() == r) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, results, path, r, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
