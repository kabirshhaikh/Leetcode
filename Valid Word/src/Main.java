import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String word = "AhI";
        boolean test = isValid(word);
        System.out.println(test);
    }


    public static boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        HashSet<Character> vowels = returnVowels();
        boolean vowelFound = false;
        boolean consonantFound = false;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (vowels.contains(currentChar)) {
                vowelFound = true;
            }

            if (Character.isLetter(currentChar) && !vowels.contains(currentChar)) {
                consonantFound = true;
            }

            if (!Character.isLetterOrDigit(currentChar)) {
                return false;
            }
        }

        return vowelFound && consonantFound;
    }

    public static HashSet<Character> returnVowels() {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        return vowels;
    }
}
