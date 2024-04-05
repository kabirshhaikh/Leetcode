import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "ubv?w";
        String test = modifyString(s);
        System.out.println(test);
    }


    public static String modifyString (String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);

            if (currentChar == '?') {
                char previousChar = (i == 0) ? ' ' : sb.charAt(i - 1);
                char nextChar = (i == sb.length() - 1) ? ' ' : sb.charAt(i + 1);

                char toSet = 'a';
                while (toSet == previousChar || toSet == nextChar) {
                    toSet++;
                }
                sb.setCharAt(i, toSet);
            }
        }

        return sb.toString();
    }
}