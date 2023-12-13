import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        String[] words = {"leet", "code"};
        char x = 'e';
        findWordsContaining(words, x);
    }

    public static List<Integer> findWordsContaining (String[] words, char x) {
        List<Integer> myList = new ArrayList<>();

        for (int i=0; i<words.length; i++) {
            String currentWord = words[i];
            boolean isPresent = false;
            for (int j=0; j<currentWord.length(); j++) {
                char currentChar = currentWord.charAt(j);
                if (currentChar == x) {
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                myList.add(i);
            }
        }


        return myList;
    }

}
