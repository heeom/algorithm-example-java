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
    public String solution2(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();

        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 1) + 1);
        }

        for (String c : completion) {
            participantMap.put(c, participantMap.get(c) - 1);
        }

        for (String p : participantMap.keySet()) {
            if (participantMap.get(p) != 0) {
                return p;
            }
        }
        return null;
    }

    public String solution3(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();

        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            int count = participantMap.get(c);
            if (count == 0) {
                participantMap.remove(c);
            } else {
                participantMap.put(c, count - 1);
            }
        }
        // entrySet() -> Map.Entry<String, Integer> 형태로 추출
        return participantMap.entrySet().iterator().next().getKey();
    }
}
