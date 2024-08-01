package ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution36 {

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        Map<Character, List<Character>> charMap = new HashMap<>();
        charMap.put('1', List.of());
        charMap.put('0', List.of());
        charMap.put('2', List.of('a', 'b', 'c'));
        charMap.put('3', List.of('d', 'e', 'f'));
        charMap.put('4', List.of('g', 'h', 'i'));
        charMap.put('5', List.of('j', 'k', 'l'));
        charMap.put('6', List.of('m', 'n', 'o'));
        charMap.put('7', List.of('p', 'q', 'r', 's'));
        charMap.put('8', List.of('t', 'u', 'v'));
        charMap.put('9', List.of('w', 'x', 'y', 'z'));

        dfs(digits, charMap, 0, result, new StringBuilder());

        return result;
    }

    public void dfs(String digits, Map<Character, List<Character>> charMap, int index, List<String> result, StringBuilder path) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        for (char c : charMap.get(digits.charAt(index))) {
            dfs(digits, charMap, index + 1, result, new StringBuilder(path).append(c));
        }
    }
}
