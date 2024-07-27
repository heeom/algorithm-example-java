package algo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BirthDayProblem {

    public static void main(String[] args) {

        int sameBirth = 0;

        for (int i = 1; i <= 100000; i++) {
            int[] birthDays = new int[23];
            for (int j = 0; j < 23; j++) {
                int birthDay = ThreadLocalRandom.current().nextInt(1, 365 + 1);
                if (IntStream.of(birthDays).anyMatch(x -> x == birthDay)) {
                    sameBirth++;
                    break;
                }
                birthDays[j] = birthDay;
            }
        }

        System.out.println("percent of sameBirth : " +  (double) sameBirth / 100000 * 100);
    }


}
