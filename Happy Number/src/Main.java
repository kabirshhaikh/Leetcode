import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int n = 19;
        boolean test = happyNumber(n);
        System.out.println(test);
    }


    public static boolean happyNumber (int n) {
        HashSet<Integer> seenSet = new HashSet<>();
        seenSet.add(n);
        while (n != 1) {
            int tempSum = 0;
            while (n > 0) {
                int digit = n % 10;
                tempSum += digit * digit;
                n = n/10;
            }
            n = tempSum;
            if (!seenSet.add(n)) {
                return false;
            }
        }
        return true;
    }
}