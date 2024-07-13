package algo;

public class RecursiveCall {

    public static void main(String[] args) {

        int result = factorial(4);
        System.out.println("result : " + result);
    }

    /**
     * n! = n * (n-1)!
     * ex)
     * 3! = 3 * 2!
     * 2! = 2 * 1
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1; // 0! = 1
        }
        return n * factorial(n-1);
    }
}
