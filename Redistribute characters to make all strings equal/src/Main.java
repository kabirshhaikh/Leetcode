import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        boolean test = makeEqual(words);
        System.out.println(test);
    }


    public static boolean makeEqual(String[] words) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        int n = words.length;
        for (int count : charCount.values()) {
            if (count % n != 0) {
                return false;
            }
        }

        return true;
    }
}
