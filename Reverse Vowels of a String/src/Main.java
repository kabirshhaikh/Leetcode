import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
        String s = "aA";
        reverseVowels(s);
    }

    public static String reverseVowels (String s) {
        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');

        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while (i < j && !set.contains(chars[i])) i++;
            while (i < j && !set.contains(chars[j])) j--;

            // swap
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }

        return new String(chars);
    }

}