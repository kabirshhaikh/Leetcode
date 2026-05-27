import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String word = "aaAbcBC";
        int output = numberOfSpecialChars(word);
        System.out.println(output);
    }

    public static int numberOfSpecialChars (String word) {
        HashMap<Character, Integer> lowercase = new HashMap<>();
        HashMap<Character, Integer> uppercase = new HashMap<>();

        int output = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                lowercase.put(ch, i);
            }

            if (Character.isUpperCase(ch) && !uppercase.containsKey(ch)) {
                uppercase.put(ch, i);
            }
        }

        for (Map.Entry<Character, Integer> m : lowercase.entrySet()) {
            char key = m.getKey();
            int val = m.getValue();

            char upperCase = Character.toUpperCase(key);

            if (uppercase.containsKey(upperCase) && uppercase.get(upperCase) > val)
                output++;
        }

        return output;
    }
}
