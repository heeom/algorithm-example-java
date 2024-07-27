package ch11;

import java.util.HashMap;

public class Solution34 {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> completionMap = new HashMap<>();

        for (String c : completion) {
            if (completionMap.containsKey(c)) {
                completionMap.put(c, completionMap.get(c) + 1);
            } else {
                completionMap.put(c, 1);
            }

        }

        for (String p : participant) {
            if (!completionMap.containsKey(p)) {
                return p;
            } else {
                Integer count = completionMap.get(p);
                if (count == 0) {
                    return p;
                } else {
                    completionMap.put(p, count - 1);
                }
            }
        }
        return null;
    }
}
