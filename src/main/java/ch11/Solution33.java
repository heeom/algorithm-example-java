package ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution33 {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Num> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count) {
                return 0;
            } else if (o1.count < o2.count) {
                return 1;
            } else {
                return -1;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            pq.offer(new Num(num, map.get(num)));
        }
        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().value;
        }
        return result;
    }

    public static class Num {
        int value;
        int count;

        public Num(int value, int count) {
            this.value = value;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public int getValue() {
            return value;
        }
    }

    public int[] topKFrequentWithOnlyHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, List<Integer>> frequencyByNum = new HashMap<>();
        for (int num : map.keySet()) {
            Integer frequency = map.get(num);
            List<Integer> numberList = frequencyByNum.getOrDefault(frequency, new ArrayList<>());
            numberList.add(num);
            frequencyByNum.put(frequency, numberList);
        }

        int [] result = new int[k];
        int idx = 0;
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (frequencyByNum.containsKey(i)) {
                for (Integer num : frequencyByNum.get(i)) {
                    result[idx] = num;
                    idx++;
                }
            }
        }
        return result;
    }
}
