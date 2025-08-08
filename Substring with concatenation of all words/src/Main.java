import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> test = findSubstring(s, words);
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0) return output;

        int wordLength = words[0].length();
        int numWords = words.length;
        int windowLength = wordLength * numWords;

        // 1. Build frequency map of words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 2. Loop over all possible offsets (0 to wordLength - 1)
        for (int offset = 0; offset < wordLength; offset++) {
            int left = offset;
            int right = offset;
            Map<String, Integer> seenMap = new HashMap<>();
            int count = 0; // number of valid words seen

            // 3. Slide the window by wordLength steps
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // If it's a valid word
                if (wordMap.containsKey(word)) {
                    seenMap.put(word, seenMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If word is overused, shrink from the left
                    while (seenMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenMap.put(leftWord, seenMap.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    // If valid window
                    if (count == numWords) {
                        output.add(left);
                    }
                } else {
                    // Reset everything
                    seenMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return output;
    }
}
