package ch12;

import java.util.*;
import java.util.stream.Collectors;

public class Solution37 {
    public static void main(String[] args) {
//        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
//        System.out.println(permute);
//        List<List<Integer>> permute2 = permute(new int[]{1, 2});
//        System.out.println(permute2);
        List<List<Integer>> lists = permuteWithDfs(new int[]{1, 2, 3});
        System.out.println(lists);
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

    public static List<List<Integer>> permuteWithDfs(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfsWithList(results, new ArrayList<>(), elements);
        return results;
    }

    public static void dfsWithList(List<List<Integer>> results, List<Integer> prev, List<Integer> elements) {
        if (elements.isEmpty()) {
            // results.add(prev);
            results.add(new ArrayList<>(prev));

        }

        for (Integer e : elements) {
            // 다음에 탐색할 elements 리스트에서 제거
            ArrayList<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            // 현재 탐색 path에는 추가
            prev.add(e);
            dfsWithList(results, prev, nextElements);
            // 다음 차수를 탐색하고 돌아왔으면 현재 path 에서 제거
            prev.remove(e);
        }
    }
}
