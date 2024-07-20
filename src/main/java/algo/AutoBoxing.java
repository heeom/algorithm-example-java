package algo;

public class AutoBoxing {
    public static void main(String[] args) {
//        primitiveType();
        referenceType();
    }

    public static void primitiveType() {
        int sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("================ primitiveType : " + end);
    }
    public static void referenceType() {
        Integer sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("================ referenceType : " + end);
    }
}
