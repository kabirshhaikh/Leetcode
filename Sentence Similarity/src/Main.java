import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String[] sentence1 = {"great","acting","skills"};
        String[] sentence2 = {"fine","drama","talent"};
        List<List<String>> li = new ArrayList<>();
        ArrayList<String> li1 = new ArrayList<>();
        ArrayList<String> li2 = new ArrayList<>();
        ArrayList<String> li3 = new ArrayList<>();
        li1.add("great");
        li1.add("fine");
        li2.add("drama");
        li2.add("acting");
        li3.add("skills");
        li3.add("talent");
        li.add(li1);
        li.add(li2);
        li.add(li3);
        boolean test = areSentencesSimilar(sentence1, sentence2, li);
        System.out.println(test);
    }


    public static boolean areSentencesSimilar (String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, List<String>> similarWordsMap = new HashMap<>();

        // Populate the map with similar pairs
        for (List<String> pair : similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            similarWordsMap.computeIfAbsent(word1, k -> new ArrayList<>()).add(word2);
            similarWordsMap.computeIfAbsent(word2, k -> new ArrayList<>()).add(word1);
        }

        // Check if corresponding words are similar
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (!word1.equals(word2) && (!similarWordsMap.containsKey(word1) || !similarWordsMap.get(word1).contains(word2))) {
                return false;
            }
        }

        return true;
    }
}