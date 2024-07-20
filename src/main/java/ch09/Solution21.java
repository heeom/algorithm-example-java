package ch09;

import java.util.*;

public class Solution21 {
    public static void main(String[] args) {
        String result = removeDuplicateLetters("cbacdcbc");
        String resultWithStack = removeDuplicateLettersWithStack("cbacdcbc");
        System.out.println("result = " + result);
        System.out.println("resultWithStack = " + resultWithStack);
    }

    public static String removeDuplicateLetters(String s) {
        for (char c : toSortedSet(s)) {
            String substring = s.substring(s.indexOf(c));
            if (toSortedSet(s).equals(toSortedSet(substring))) {
                return c + removeDuplicateLetters(substring.replaceAll(String.valueOf(c), ""));
            }
        }
        return "";
    }

    private static Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (o1 == o2) {
                  return 0;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public static String removeDuplicateLettersWithStack(String s) {
        Map<Character, Boolean> seen = new HashMap<>();
        Map<Character, Integer> counter = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        // 1. counter setting
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter.put(c, counter.get(c) == null? 1 : counter.get(c) + 1);
            seen.put(c, false);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter.put(c, counter.get(c) - 1);
            // 이미 처리된 문자면 skip
            if (seen.get(c) == null || seen.get(c)) {
                continue;
            }
            // 앞 문자가 c 보다 뒤에 가야하는 문자 && 앞 문자가 중복 문자인 경우
            if (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                Character pop = stack.pop();
                // 처리 안한 문자로 변경
                seen.put(pop, false);
                // counter--;
                counter.put(pop, counter.get(pop) - 1);
            }
            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
