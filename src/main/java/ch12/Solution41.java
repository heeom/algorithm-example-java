package ch12;

import java.util.*;

public class Solution41 {

    public static void main(String[] args) {
        List<String> itinerary = findItinerary(List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK")));
        System.out.println(itinerary);
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        dfs(map, "JFK", result);
        return result;
    }

    public static void dfs(Map<String, PriorityQueue<String>> map, String from, List<String> result) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(map, map.get(from).poll(), result);
        }
        result.add(0, from);
    }
}
