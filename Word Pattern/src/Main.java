import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String pattern = "abba";
        String s = "dog cat cat fish";
        boolean test = wordPattern(pattern, s);
        System.out.println(test);
    }

    public static boolean wordPattern (String pattern, String s) {
        String[] sArray = s.split(" ");
        if (pattern.length() != sArray.length) {
            return false;
        }

        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = sArray[i];

            if (charToStr.containsKey(c)) {
                if (!charToStr.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (strToChar.containsKey(word)) {
                    if (strToChar.get(word) != c) {
                        return false;
                    }
                } else {
                    charToStr.put(c, word);
                    strToChar.put(word, c);
                }
            }
        }

        return true;
    }
}