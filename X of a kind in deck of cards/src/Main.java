import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] deck = {1,2,3,4,4,3,2,1};
        boolean test = hasGroupsSizeX(deck);
        System.out.println(test);
    }


    public static boolean hasGroupsSizeX (int[] deck) {
        if (deck.length < 2) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : deck) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Step 2: Find the GCD of all counts
        int gcd = 0;
        for (int count : countMap.values()) {
            gcd = findGCD(gcd, count);
            if (gcd == 1) return false; // If at any point GCD is 1, partitioning isn't possible
        }

        return gcd > 1;
    }

    private static int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }
}
