import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        int test = numberOfSpecialChars(word);
        System.out.println(test);
    }

    public static int numberOfSpecialChars(String word) {
        HashSet<Character> lowercase = new HashSet<>();
        HashSet<Character> uppercase = new HashSet<>();

        int output = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                uppercase.add(ch);
            } else {
                lowercase.add(ch);
            }
        }

        for (Character c : lowercase) {
            char upperCaseCharacter = Character.toUpperCase(c);
            if (uppercase.contains(upperCaseCharacter)) {
                output++;
            }
        }

        return output;
    }
}
