import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        stringMatching(words);
    }

    public static List<String> stringMatching (String[] words) {
        HashSet<String> mySet = new HashSet<>();
        for (int i=0; i<words.length; i++) {
           String currentWord = words[i];
           for (int j=i+1; j<words.length; j++) {
               String nextWord = words[j];
               if (currentWord.contains(nextWord)) {
                   mySet.add(nextWord);
               }
               else if (nextWord.contains(currentWord)) {
                   mySet.add(currentWord);
               }
           }
       }
       return new ArrayList<>(mySet);
    }

}