import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int num1 = 3;
        int num2 = 5;
        int test = minimizeXor(num1, num2);
        System.out.println(test);
    }


    public static int minimizeXor (int num1, int num2) {
        int numberOfOnesInNum2 = Integer.bitCount(num2); // Count 1's in num2
        int x = 0; // Resulting number

        // Step 1: Use bits from num1 where possible
        for (int i = 31; i >= 0 && numberOfOnesInNum2 > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // If bit i in num1 is set
                x |= (1 << i); // Set bit i in x
                numberOfOnesInNum2--; // Decrease remaining 1's needed
            }
        }

        // Step 2: Add remaining 1's in the smallest available positions
        for (int i = 0; i <= 31 && numberOfOnesInNum2 > 0; i++) {
            if ((x & (1 << i)) == 0) { // If bit i in x is not set
                x |= (1 << i); // Set bit i in x
                numberOfOnesInNum2--; // Decrease remaining 1's needed
            }
        }

        return x;
    }
}