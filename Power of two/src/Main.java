public class Main {
    public static void main (String[] args) {
        int n = 16;
        boolean test = isPowerOfTwo(n);
        System.out.println(test);
    }


    public static boolean isPowerOfTwo (int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}