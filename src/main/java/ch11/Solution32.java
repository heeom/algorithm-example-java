package ch11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution32 {

    public static void main(String[] args) {
        String s = " ";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && left < map.get(c)) {
                left = map.get(c) + 1;
            } else {
                max = Math.max(max, right - left + 1);
            }
            map.put(c, right);
            right++;
        }
        return max;
    }
}
