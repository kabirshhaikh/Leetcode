public class Main {
    public static void main (String[] args) {
        int n = 10;
        int m = 3;
        differenceOfSums(n, m);
    }



    public static int differenceOfSums (int n, int m) {
        int nonDivisible = 0;
        int divisible = 0;

        for (int i=1; i<=n; i++) {
            if (i % m == 0) {
                divisible = divisible + i;
            }
            else {
                nonDivisible = nonDivisible + i;
            }
        }

        return nonDivisible - divisible;
    }
}