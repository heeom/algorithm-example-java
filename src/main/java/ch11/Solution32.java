package ch11;

import java.util.HashMap;

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
            // 슬라이딩 윈도우와 겹치는 경우만 오른쪽으로 한칸 이동
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
