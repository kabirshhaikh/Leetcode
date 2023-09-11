import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String text = "leet code";
        String brokenLetters = "e";
        int test = canBeTypedWords(text, brokenLetters);
        System.out.println(test);
    }


    public static int canBeTypedWords (String text, String brokenLetters) {
        int count = 0;
        String[] textInput = text.split(" ");
        HashSet<Character> mySet = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            char currentChar = brokenLetters.charAt(i);
            mySet.add(currentChar);
        }
        for (int i = 0; i < textInput.length; i++) {
            String currentWord = textInput[i];
            boolean canTypeWord = true;
            for (int j = 0; j < currentWord.length(); j++) {
                char character = currentWord.charAt(j);
                if (mySet.contains(character)) {
                    canTypeWord = false;
                    break;
                }
            }
            if (canTypeWord) {
                count++;
            }
        }
        return count;
    }
}
