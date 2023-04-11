import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] digits = {1,2,3};
        plusOne(digits);
    }
    public static int[] plusOne (int[] digits) {
        long totalSum = 0;
        for (int i=0; i<digits.length; i++) {
            totalSum = totalSum * 10 + digits[i];
        }
        totalSum = totalSum + 1;
        String total = Long.toString(totalSum);
        System.out.println("Total Sum: " +totalSum);
        String[] result = total.split("");
        int[] digitsArray = new int[result.length];

        for (int i=0; i<result.length; i++) {
            digitsArray[i] = Integer.parseInt(result[i]);
        }
        System.out.println(Arrays.toString(digitsArray));
        return digitsArray;
    }
}