import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "abbcccddddeeeeedcba";
        int test = maxPower(s);
        System.out.println(test);
    }


    public static int maxPower (String s) {
        int maxLength = 0;
        int currentLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }
}