package ch04;

public class JavaPerf {

    private static final int MILLION = 100000000;
    public static void main(String[] args) {
        int[] intEl = new int[MILLION];

        long start = System.currentTimeMillis();
        for (int i = 0; i < MILLION; i++) {
            intEl[i] = 1;
        }
        long end = System.currentTimeMillis();
        System.out.println("time for insert data : " + (end - start));

        intEl[MILLION - 1] = 2;

        int index = 0;

        long start2 = System.currentTimeMillis();
        while (intEl[index] != 2) {
            index++;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("time for lookup data : " + (end2 - start2));
    }

//    time for insert data : 150
//    time for lookup data : 39
}
