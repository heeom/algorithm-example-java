package ch06;

import java.util.*;
import java.util.stream.Collectors;

public class Solution5  {

    public static void main(String[] args) {
        groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        // List.of, Arrays.asList() -> immutable, new ArrayList<>() -> mutable
        Map<String, List<String>> stringMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // stringMap.containsKey(key);로 새로운 key인지 확인할 수도 있다
            List<String> stringList = stringMap.getOrDefault(key, new ArrayList<>());
            stringList.add(str);
            stringMap.put(key, stringList);
        }

        return new ArrayList<>(stringMap.values());
    }
}
