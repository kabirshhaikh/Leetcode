import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] agrs) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int test = compress(chars);
        System.out.println(test);
    }

    public static int compress (char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }

        int writeIdx = 0;  // Index to write compressed characters
        int readIdx = 0;   // Index to read characters to be compressed

        while (readIdx < chars.length) {
            char currentChar = chars[readIdx];
            int count = 0;

            // Count consecutive repeating characters
            while (readIdx < chars.length && chars[readIdx] == currentChar) {
                readIdx++;
                count++;
            }

            // Write the character
            chars[writeIdx] = currentChar;
            writeIdx++;

            // If count is greater than 1, write its digits
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[writeIdx] = digit;
                    writeIdx++;
                }
            }
        }

        return writeIdx;
    }

}