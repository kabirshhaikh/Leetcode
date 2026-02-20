import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "00110011";
        int test = countBinarySubstrings(s);
        System.out.println(test);
    }

    public static int countBinarySubstrings(String s) {
        List<Integer> pattern = new ArrayList<>();
        int output = 0;

        int i = 0;

        while (i < s.length()) {
            int count = 0;
            char currentChar = s.charAt(i);

            while (i < s.length() && s.charAt(i) == currentChar) {
                count++;
                i++;
            }

            pattern.add(count);
        }

        for (int j = 1; j < pattern.size(); j++) {
            output = output + Math.min(pattern.get(j - 1), pattern.get(j));
        }

        return output;
    }
}
