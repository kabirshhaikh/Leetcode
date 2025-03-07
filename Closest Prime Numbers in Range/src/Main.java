import java.util.*;

public class Main {
    public static void main (String[] args) {
        int left = 10;
        int right = 19;
        int[] test = closestPrimes(left, right);
        System.out.println(Arrays.toString(test));
    }


    private static int[] closestPrimes (int left, int right) {
        int[] output = {-1, -1};

        boolean[] isPrime = sieveOfEratosthenes(right);

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDifference) {
                minDifference = diff;
                output[0] = primes.get(i - 1);
                output[1] = primes.get(i);
            }
        }

        return output;
    }


    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
