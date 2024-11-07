import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] test = numberOfLines(widths, s);
        System.out.println(Arrays.toString(test));
    }

    public static int[] numberOfLines (int[] widths, String s) {
        int line = 1;
        int pixels = 0;
        int[] output = new int[2];

        int right = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            int indexOfCurrentAlphabet = currentChar - 'a';
            int charWidth = widths[indexOfCurrentAlphabet];

            if (pixels + charWidth > 100) {
                pixels = charWidth;
                line = line + 1;
            }
            else {
                pixels = pixels + charWidth;
            }
            right = right + 1;
        }

        output[0] = line;
        output[1] = pixels;

        return output;
    }
}
