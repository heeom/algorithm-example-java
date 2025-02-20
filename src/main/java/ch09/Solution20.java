package ch09;

import java.util.*;

public class Solution20 {

    public static void main(String[] args) {
        boolean valid = isValid("{[(]]}");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Set<String> left = Set.of("{", "[", "(");
        Set<String> right = Set.of("}", "]", ")");
        Set<String> normal = Set.of("{}", "[]", "()");
        ArrayDeque<String> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < s.length()) {
            String c = String.valueOf(s.charAt(idx));
            if (left.contains(c)) {
                stack.push(c);
            }
            if (right.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                String pop = stack.pop();
                if (!normal.contains(pop + c)) {
                    return false;
                }
            }
            idx++;
        }
        return stack.isEmpty();
    }
    public static boolean isValidWithMap(String s) {
        Map<Character, Character> table = new HashMap<>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!table.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || table.get(c)!= stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
