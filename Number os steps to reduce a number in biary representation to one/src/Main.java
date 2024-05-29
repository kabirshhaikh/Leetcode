import java.math.BigInteger;

public class Main {
    public static void main (String[] args) {
        String s = "1101";
        int test = numSteps(s);
        System.out.println(test);
    }


    public static int numSteps (String s) {
        int N = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }
}
