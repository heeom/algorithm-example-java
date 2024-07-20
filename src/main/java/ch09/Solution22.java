package ch09;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution22 {
    public static void main(String[] args) {
        int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println("result : "+result);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length-1; i++) {
            int temp = temperatures[i];
            int count = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temp < temperatures[j]) {
                    count++;
                    result[i] = count;
                    break;
                }
                count++;
            }
        }
        return result;
    }

    public static int[] dailyTemperaturesWithStack(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}
