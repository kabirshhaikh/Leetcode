import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "11111222223";
        int k = 3;
        String test = digitSum(s, k);
        System.out.println(test);
    }

    public static String digitSum (String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        // Continue until length of sb is less than or equal to k
        while (sb.length() > k) {
            StringBuilder newString = new StringBuilder();
            int i = 0;

            // Iterate over characters of sb
            while (i < sb.length()) {
                int sum = 0;
                int count = 0;

                // Calculate sum of digits for each group
                while (i < sb.length() && count < k) {
                    sum += sb.charAt(i) - '0';
                    i++;
                    count++;
                }

                newString.append(sum);
            }

            sb = newString; // Update sb with newString
        }

        return sb.toString();
    }

}

