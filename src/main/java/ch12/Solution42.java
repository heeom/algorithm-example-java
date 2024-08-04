package ch12;

import java.util.*;

public class Solution42 {

    public static void main(String[] args) {
        String [][] tickets = new String[3][2];
        tickets[0] = new String[] {"ICN", "JFK"};
        tickets[1] = new String[] {"HND", "IAD"};
        tickets[2] = new String[] {"JFK", "HND"};
        String[] solution = solution(tickets);
        System.out.println(solution);
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        List<String> path = new LinkedList<>();
        dfs(map, "ICN", path);
        answer = path.toArray(new String[0]);
        return answer;
    }

    public static void dfs(Map<String, PriorityQueue<String>> map, String from, List<String> answer) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(map, map.get(from).poll(), answer);
        }
        answer.add(0, from);
    }
}
