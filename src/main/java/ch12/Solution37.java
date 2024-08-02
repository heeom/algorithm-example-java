package ch12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution37 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
        List<List<Integer>> permute2 = permute(new int[]{1, 2});
        System.out.println(permute2);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i<nums.length; i++) {
            HashSet<Integer> keys = new HashSet<>();
            keys.add(i);
            ArrayList<Integer> path = new ArrayList<>();
            path.add(nums[i]);
            dfs(path, keys, result, nums);
        }
        return result;
    }

    public static void dfs(List<Integer> path, Set<Integer> keys, List<List<Integer>> result, int [] nums) {
        if (path.size() == nums.length) {
            result.add(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!keys.contains(i)) {
                path.add(nums[i]);
                keys.add(i);
                dfs(new ArrayList<>(path), new HashSet<>(keys), result, nums);
                // stack을 써도 좋을듯
                keys.remove(i);
                path.remove(path.size() - 1);
            }
        }
    }
}
