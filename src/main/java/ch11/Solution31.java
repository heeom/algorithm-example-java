package ch11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution31 {

    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char j : jewels.toCharArray()) {
            hashMap.put(j, 0);
        }

        for (char stone : stones.toCharArray()) {
            Integer value = hashMap.get(stone);
            if (value != null) {
                hashMap.put(stone, value + 1);
            }
        }

        int sum = 0;
        Set<Character> characters = hashMap.keySet();
        for (char jewel : characters) {
            sum += hashMap.get(jewel);
        }
        return sum;
    }
    public int numJewelsInStonesWithHashMap(String jewels, String stones) {
        HashMap<Character, Integer> stoneMap = new HashMap<>();
        for (char stone : stones.toCharArray()) {
            if (stoneMap.containsKey(stone)) {
                stoneMap.put(stone, stoneMap.get(stone) + 1);
            } else {
                stoneMap.put(stone, 1);
            }
        }

        int count = 0;
        for (char jewel : jewels.toCharArray()) {
            if (stoneMap.containsKey(jewel)) {
                count += stoneMap.get(jewel);
            }
        }
        return count;
    }

    public int numJewelsInStonesWithHashSet(String jewels, String stones) {
        int count = 0;
        Set<Character> jewelSet = new HashSet<>();

        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}
