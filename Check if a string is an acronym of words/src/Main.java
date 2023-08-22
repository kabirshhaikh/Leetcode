import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<String> words = new ArrayList<>();
        words.add("alice");
        words.add("bob");
        words.add("charlie");
        String s = "abc";
        boolean test = isAcronym(words, s);
        System.out.println(test);
    }

    public static boolean isAcronym (List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }

        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            char firstChar = currentWord.charAt(0);
            if (firstChar != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
