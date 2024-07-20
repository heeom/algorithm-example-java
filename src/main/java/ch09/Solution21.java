package ch09;

import java.util.*;

public class Solution21 {
    public static void main(String[] args) {
        String result = removeDuplicateLetters("cbacdcbc");

        System.out.println(result);
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
}
