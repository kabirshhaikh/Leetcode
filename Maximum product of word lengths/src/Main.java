import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int test = maxProduct(words);
        System.out.println(test);
    }


    public static int maxProduct (String[] words) {
        int n = words.length;
        int[] masks = new int[n];  // Bitmask representation of each word
        int[] lengths = new int[n]; // Lengths of words

        // Step 1: Compute bitmask for each word
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= (1 << (c - 'a'));  // Set bit for each character
            }
            masks[i] = mask;
            lengths[i] = words[i].length();
        }

        int maxLength = 0;
        // Step 2: Compare words using bitwise AND
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) { // No common letters
                    maxLength = Math.max(maxLength, lengths[i] * lengths[j]);
                }
            }
        }

        return maxLength;
    }

}
