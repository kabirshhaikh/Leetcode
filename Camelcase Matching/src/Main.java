import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        camelMatch(queries, pattern);
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> myList = new ArrayList<>();

        for (String currentWord : queries) {
            int left = 0;
            int right = 0;
            boolean matches = true;

            while (left < currentWord.length() && right < pattern.length()) {
                char currentCharacter = currentWord.charAt(left);
                if (currentCharacter == pattern.charAt(right)) {
                    left++;
                    right++;
                } else if (Character.isUpperCase(currentCharacter)) {
                    matches = false;  // Uppercase mismatch, set matches to false
                    break;
                } else {
                    left++;
                }
            }

            if (right < pattern.length()) {
                matches = false;  // If pattern hasn't been fully matched, set matches to false
            }

            myList.add(matches);
        }

        for (boolean result : myList) {
            System.out.println(result);
        }

        return myList;
    }
}
